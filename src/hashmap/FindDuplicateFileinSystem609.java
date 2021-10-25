package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateFileinSystem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] str = path.split(" ");
            for (String s : str) {
                System.out.print(s + " ");
            }
            String curPath = str[0];
            for (int i = 1; i < str.length; i++) {
                String file = str[i];
                int contentsIndex = file.indexOf("(");
                String filePath = curPath + "/" + file.substring(0, contentsIndex);
                String fileContent = file.substring(contentsIndex + 1, file.length() - 1);
                if (map.containsKey(fileContent)) {
                    map.get(fileContent).add(filePath);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(filePath);
                    map.put(filePath, list);
                }
            }
        }
        return map.values().stream().filter(strings -> strings.size() > 1).collect(Collectors.toList());
    }
}
