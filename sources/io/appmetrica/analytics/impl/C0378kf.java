package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
import io.appmetrica.analytics.plugins.StackTraceItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.kf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0378kf {

    /* renamed from: a  reason: collision with root package name */
    public final C0296ha f1067a;

    public C0378kf(C0296ha c0296ha) {
        this.f1067a = c0296ha;
    }

    public final C0620to a(PluginErrorDetails pluginErrorDetails) {
        ArrayList arrayList;
        String exceptionClass = pluginErrorDetails.getExceptionClass();
        String message = pluginErrorDetails.getMessage();
        List<StackTraceItem> stacktrace = pluginErrorDetails.getStacktrace();
        String platform = pluginErrorDetails.getPlatform();
        String virtualMachineVersion = pluginErrorDetails.getVirtualMachineVersion();
        Map<String, String> pluginEnvironment = pluginErrorDetails.getPluginEnvironment();
        String str = (String) this.f1067a.b.a();
        Boolean bool = (Boolean) this.f1067a.c.a();
        if (stacktrace != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stacktrace, 10));
            for (StackTraceItem stackTraceItem : stacktrace) {
                arrayList.add(new C0256fm(stackTraceItem.getClassName(), stackTraceItem.getFileName(), stackTraceItem.getLine(), stackTraceItem.getColumn(), stackTraceItem.getMethodName(), null));
            }
        } else {
            arrayList = null;
        }
        return new C0620to(new C0361jo(exceptionClass, message, arrayList, null, null), null, null, platform, virtualMachineVersion, pluginEnvironment, str, bool);
    }
}
