//package cch.order.v1;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Component
//public class EmpWorkYearJob {
//
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private OrgService orgService;
//    @Autowired
//    private EmpWorkYearTask empWorkYearTask;
//
//    @Resource(name = "taskExecutor")
//    private ExecutorService taskExecutor;
//
//    @Scheduled(cron = "0 0 0/1 * * ?") // 每分钟执行一次
//    public void calcWorkYear() {
//        XxlJobHelper.log("==========XXL-JOB RUNING, 定时计算人员工龄===========");
//        long start = System.currentTimeMillis();
//        try {
//            List<EmpCorePO> list = employeeService.findEmployeeAll(null);
//            List<EmpDetailPO> list2 = employeeService.findEmpDetailAll();
//            List<OrganizationPO> list3 = orgService.findAllOrgList();
//            List<EmpWorkExpPO> list4 = employeeService.findEmpWorkExpAll();
//            Map<Integer, EmpDetailPO> detailMap = list2.stream().collect(Collectors.toMap(EmpDetailPO::getEmpId, detail -> detail));
//            list2 = null;
//            Map<Integer, OrganizationPO> orgCompanyMap = list3.stream().collect(Collectors.toMap(OrganizationPO::getId, org -> org));
//            list3 = null;
//            Map<Integer, List<EmpWorkExpPO>> workExpMap = new HashMap<>();
//            list4.forEach(po -> {
//                List<EmpWorkExpPO> empWorkExpPOList = workExpMap.get(po.getEmpId());
//                if (empWorkExpPOList == null) {
//                    empWorkExpPOList = new ArrayList<>();
//                    workExpMap.put(po.getEmpId(), empWorkExpPOList);
//                }
//                empWorkExpPOList.add(po);
//            });
//            list4 = null;
//            int failCount = 0;
//            for (EmpCorePO corePO : list) {
//                taskExecutor.submit(() -> {
//                    try {
//                        Map<String, Object> info = employeeService.findEmpWorkYear(corePO, detailMap.get(corePO.getId()).getWorkDate(), orgCompanyMap.get(corePO.getOrgId()).getCompanyId(), workExpMap.get(corePO.getId()));
//                        Double innerWorkingMonths = (Double) info.get("innerWorkingMonths");
//                        Double otherWorkingMonths = (Double) info.get("otherWorkingMonths");
//                        //本企工龄
//                        String[] innerWorkingMonthss = innerWorkingMonths.toString().split("\\.");
//                        int innerWorkingYear = Integer.parseInt(innerWorkingMonthss[0]) / 12;
//                        int innerWorkingMonth = Integer.parseInt(innerWorkingMonthss[0]) - (Integer.parseInt(innerWorkingMonthss[0]) / 12) * 12;
//                        //外企工龄
//                        String[] otherWorkingMonthss = otherWorkingMonths.toString().split("\\.");
//                        int otherWorkingYear = Integer.parseInt(otherWorkingMonthss[0]) / 12;
//                        int otherWorkingMonth = Integer.parseInt(otherWorkingMonthss[0]) - (Integer.parseInt(otherWorkingMonthss[0]) / 12) * 12;
//                        empWorkYearTask.doCalcWorkYear(corePO.getId(), corePO.getEmpNo(), innerWorkingYear, innerWorkingMonth, otherWorkingYear, otherWorkingMonth);
//                    } catch (Exception e) {
//                        failCount++;
//                        log.error(corePO.getEmpNo() + "计算工龄异常", e);
//                        e.printStackTrace();
//                    }
//                });
//            }
//            XxlJobHelper.log("==========XXL-JOB TOTAL: " + list.size() + "===========");
//            XxlJobHelper.log("==========XXL-JOB SUCCESS: " + (list.size() - failCount) + "===========");
//            XxlJobHelper.log("==========XXL-JOB FAIL: " + failCount + "===========");
//            XxlJobHelper.log("==========XXL-JOB FINISH, 定时计算人员工龄===========");
//        } catch (Exception e) {
//            e.printStackTrace();
//            XxlJobHelper.log("==========XXL-JOB Error===========" + e.getMessage());
//        } finally {
//            XxlJobHelper.log("==========XXL-JOB COST: " + (System.currentTimeMillis() - start) + "ms===========");
//        }
//    }
//}
