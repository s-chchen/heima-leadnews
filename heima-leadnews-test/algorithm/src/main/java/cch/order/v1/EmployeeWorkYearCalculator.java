//package cch.order.v1;
//
//import java.util.concurrent.*;
//
//public class EmployeeWorkYearCalculator {
//    private static final int THREAD_POOL_SIZE = 5;
//
//    public void calculateWorkYear(List<EmpCorePO> list, EmpDetailService employeeService, OrgService orgService, EmpWorkExpService employeeWorkExpService, EmpWorkYearTask empWorkYearTask) throws InterruptedException, ExecutionException {
//        List<EmpCorePO> list1 = employeeService.findEmployeeAll(null);
//        List<EmpDetailPO> list2 = employeeService.findEmpDetailAll();
//        List<OrganizationPO> list3 = orgService.findAllOrgList();
//        List<EmpWorkExpPO> list4 = employeeService.findEmpWorkExpAll();
//
//        Map<Integer, EmpDetailPO> detailMap = list2.stream().collect(Collectors.toMap(EmpDetailPO::getEmpId, detail -> detail));
//        list2 = null;
//        Map<Integer, OrganizationPO> orgCompanyMap = list3.stream().collect(Collectors.toMap(OrganizationPO::getId, org -> org));
//        list3 = null;
//        Map<Integer, List<EmpWorkExpPO>> workExpMap = new ConcurrentHashMap<>();
//        list4.forEach(po -> {
//            List<EmpWorkExpPO> empWorkExpPOList = workExpMap.computeIfAbsent(po.getEmpId(), k -> new CopyOnWriteArrayList<>());
//            empWorkExpPOList.add(po);
//        });
//        list4 = null;
//
//        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//        CountDownLatch countDownLatch = new CountDownLatch(list1.size());
//
//        for (EmpCorePO corePO : list1) {
//            executorService.submit(() -> {
//                try {
//                    Map<String, Object> info = employeeService.findEmpWorkYear(corePO, detailMap.get(corePO.getId()).getWorkDate(), orgCompanyMap.get(corePO.getOrgId()).getCompanyId(), workExpMap.get(corePO.getId()));
//                    Double innerWorkingMonths = (Double) info.get("innerWorkingMonths");
//                    Double otherWorkingMonths = (Double) info.get("otherWorkingMonths");
//                    //本企工龄
//                    String[] innerWorkingMonthss = innerWorkingMonths.toString().split("\\.");
//                    int innerWorkingYear = Integer.parseInt(innerWorkingMonthss[0]) / 12;
//                    int innerWorkingMonth = Integer.parseInt(innerWorkingMonthss[0]) - (Integer.parseInt(innerWorkingMonthss[0]) / 12) * 12;
//                    //外企工龄
//                    String[] otherWorkingMonthss = otherWorkingMonths.toString().split("\\.");
//                    int otherWorkingYear = Integer.parseInt(otherWorkingMonthss[0]) / 12;
//                    int otherWorkingMonth = Integer.parseInt(otherWorkingMonthss[0]) - (Integer.parseInt(otherWorkingMonthss[0]) / 12) * 12;
//                    empWorkYearTask.doCalcWorkYear(corePO.getId(), corePO.getEmpNo(), innerWorkingYear, innerWorkingMonth, otherWorkingYear, otherWorkingMonth);
//                } catch (Exception e) {
//                    log.error(corePO.getEmpNo() + "计算工龄异常", e);
//                    e.printStackTrace();
//                } finally {
//                    countDownLatch.countDown();
//                }
//            });
//        }
//
//        countDownLatch.await();
//        executorService.shutdown();
//    }
//}
