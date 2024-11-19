package Design_questions.inMemoryDatabase;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Table {
    private String name;
    private AtomicInteger autoIncrementid=new AtomicInteger(1);
    private Map<String,Map<String,Set<Integer>>>indexMap=new HashMap<>();
    Map<Integer,Row> rowMap=new HashMap<>();
    public Table(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Row  insert(String name,int age){
        int id=autoIncrementid.getAndIncrement();
        Row row = new Row(id, name, age);
        rowMap.put(id, row);
        createIndex("name",name,id);
        return row;
    }
    public void createIndex(String field,String value, int id){
        indexMap.putIfAbsent(field,new HashMap<>());
        indexMap.get(field).putIfAbsent(value,new HashSet<>());
        indexMap.get(field).get(value).add(id);
    }
    //logic to delete index
    public void deleteIndex(String field,String value, int id){

        indexMap.get(field).remove(value);

    }
    // logic to search with index field
    public List<Row> selectQueryByIndexField(String field,String value){
        // search when we have index on field
        if( indexMap.containsKey(field) && indexMap.get(field).containsKey(value)){
         Set<Integer>idList=indexMap.get(field).get(value);
            List<Row> result = new ArrayList<>();
            for(int id:idList){
            Row resRow= rowMap.get(id);
            result.add(resRow);
         }
            return  result;
        }
        // search when we don't have index on field
         List<Row>result1=new ArrayList<>();
        for(Row row:rowMap.values()){
            if(row.getName().equals(value)){
                result1.add(row);
            }
        }
        return result1;
    }
    public void update(Integer id,String name,int age){
        Row row=rowMap.get(id);
        deleteIndex("name",row.getName(),id);
        row.setAge(age);
        row.setName(name);
        createIndex("name",row.getName(),id);
    }
    public void delete(int id) {
        Row row = rowMap.remove(id);
        if (row != null) {
            // Remove from indexes
            deleteIndex("name", row.getName(), id);
        }
    }
    public List<Row> getAllRows(){
        return  new ArrayList<>((Collection) rowMap.values());
    }
}
