package utils;

import java.util.HashMap;

public class ItemsCatalog {
    private static HashMap<Integer, String> map;

    private static void createCatalog() {
        map = new HashMap<Integer, String>();
        map.put(70, "Flying Ninja");
        map.put(37, "Happy Ninja");
    }

    public static int getProductId(String item){
        createCatalog();
        return getKeyFromValue(map,item);

    }

    private static int getKeyFromValue(HashMap hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return Integer.parseInt(o.toString());
            }
        }
        return 0;
    }

}
