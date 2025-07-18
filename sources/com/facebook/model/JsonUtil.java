package com.facebook.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class JsonUtil {

    /* loaded from: classes3.dex */
    private static final class JSONObjectEntry implements Map.Entry<String, Object> {
        private final String key;
        private final Object value;

        JSONObjectEntry(String str, Object obj) {
            this.key = str;
            this.value = obj;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("JSONObjectEntry is immutable");
        }
    }

    JsonUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void jsonObjectClear(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            keys.next();
            keys.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean jsonObjectContainsValue(JSONObject jSONObject, Object obj) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object opt = jSONObject.opt(keys.next());
            if (opt != null && opt.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<Map.Entry<String, Object>> jsonObjectEntrySet(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashSet.add(new JSONObjectEntry(next, jSONObject.opt(next)));
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<String> jsonObjectKeySet(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void jsonObjectPutAll(JSONObject jSONObject, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Collection<Object> jsonObjectValues(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            arrayList.add(jSONObject.opt(keys.next()));
        }
        return arrayList;
    }
}
