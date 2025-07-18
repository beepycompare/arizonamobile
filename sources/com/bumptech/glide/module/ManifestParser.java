package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes3.dex */
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    private ApplicationInfo getOurApplicationInfo() throws PackageManager.NameNotFoundException {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    public List<GlideModule> parse() {
        ApplicationInfo ourApplicationInfo;
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ourApplicationInfo = getOurApplicationInfo();
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Failed to parse glide modules", e);
            }
        }
        if (ourApplicationInfo != null && ourApplicationInfo.metaData != null) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Got app info metadata: " + ourApplicationInfo.metaData);
            }
            for (String str : ourApplicationInfo.metaData.keySet()) {
                if (GLIDE_MODULE_VALUE.equals(ourApplicationInfo.metaData.get(str))) {
                    arrayList.add(parseModule(str));
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Finished loading Glide modules");
                return arrayList;
            }
            return arrayList;
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Got null app info metadata");
            return arrayList;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static GlideModule parseModule(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        Object obj;
        Class cls4;
        try {
            try {
                obj = Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throwInstantiateGlideModuleException(cls4, e);
                obj = null;
                if (!(obj instanceof GlideModule)) {
                }
            } catch (InstantiationException e2) {
                throwInstantiateGlideModuleException(cls3, e2);
                obj = null;
                if (!(obj instanceof GlideModule)) {
                }
            } catch (NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls2, e3);
                obj = null;
                if (!(obj instanceof GlideModule)) {
                }
            } catch (InvocationTargetException e4) {
                throwInstantiateGlideModuleException(cls, e4);
                obj = null;
                if (!(obj instanceof GlideModule)) {
                }
            }
            if (!(obj instanceof GlideModule)) {
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
            }
            return (GlideModule) obj;
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
