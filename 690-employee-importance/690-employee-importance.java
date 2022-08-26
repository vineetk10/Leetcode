/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> hm = new HashMap<>();
        
        for(Employee emp : employees)
        {
            hm.put(emp.id, emp);
        }
        GetImp(hm, id);
        return sum;
    }
    
    public void GetImp(HashMap<Integer, Employee> hm, int key)
    {
        Employee emp =hm.get(key);
        sum+= emp.importance;
        List<Integer> subordinates = emp.subordinates;
        
        for(Integer sub : subordinates)
        {
            GetImp(hm, sub);
        }
    }
}