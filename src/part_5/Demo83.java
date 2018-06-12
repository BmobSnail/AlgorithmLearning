package part_5;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串问题
 * 数组中两个字符串的最小距离
 *
 * 题目：
 * 给定一个字符串数 strs,再给定两个字符串 str1 和 str2，返回在 strs 中 str1 与 str2 的
 * 最小距离，如果 str1 或 str2 为 null，或不在 strs 中，返回 -1
 *
 * 举例:
 * strs=["1","3","3","2","3","1"],str1="1",str2="2",返回2
 * strs=["CD"],str1="CD",str2="AB",返回-1
 * */
public class Demo83 {

    public int minDistance(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null)
            return -1;
        if (str1.equals(str2))
            return 0;
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = Math.min(min,last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (strs[i].equals(str2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    class Record{
        HashMap<String,HashMap<String,Integer>> record;

        public Record(String[] strArr) {
            record = new HashMap<>();
            HashMap<String,Integer> indexMap = new HashMap<>();
            for (int i = 0; i != strArr.length; i++) {
                String curStr = strArr[i];
                update(indexMap,curStr,i);
                indexMap.put(curStr,i);
            }
        }

        private void update(HashMap<String, Integer> indexMap, String str, int i) {
            if (!record.containsKey(str))
                record.put(str,new HashMap<>());
            HashMap<String,Integer> strMap = record.get(str);
            for (Map.Entry<String, Integer> lastEntry : indexMap.entrySet()) {
                String key = lastEntry.getKey();
                int index = lastEntry.getValue();
                if (!key.equals(str)) {
                    HashMap<String,Integer> lastMap = record.get(key);
                    int curMin = i - index;
                    if (strMap.containsKey(key)) {
                        int preMin = strMap.get(key);
                        if (curMin < preMin) {
                            strMap.put(key, curMin);
                            lastMap.put(str, curMin);
                        }
                    } else {
                        strMap.put(key,curMin);
                        lastMap.put(str,curMin);
                    }
                }
            }
        }

        public int minDistance(String str1, String str2) {
            if (str1 == null || str2 == null)
                return -1;
            if (str1.equals(str2))
                return 0;
            if (record.containsKey(str1) && record.get(str1).containsKey(str2))
                return record.get(str1).get(str2);
            return -1;
        }
    }

}
