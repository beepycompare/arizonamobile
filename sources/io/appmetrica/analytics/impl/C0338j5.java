package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.j5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0338j5 implements ModuleAdRevenueProcessor, ModuleAdRevenueProcessorsHolder {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1033a = new ArrayList();

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final String getDescription() {
        return CollectionsKt.joinToString$default(this.f1033a, null, "Composite processor with " + this.f1033a.size() + " children: [", "]", 0, null, C0313i5.f1018a, 25, null);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        Object obj;
        boolean process;
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Processing Ad Revenue for " + Arrays.toString(objArr), new Object[0]);
        Iterator it = this.f1033a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ModuleAdRevenueProcessor moduleAdRevenueProcessor = (ModuleAdRevenueProcessor) obj;
            try {
                process = moduleAdRevenueProcessor.process(Arrays.copyOf(objArr, objArr.length));
                if (!process) {
                    LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue was not processed by " + moduleAdRevenueProcessor.getDescription(), new Object[0]);
                }
            } catch (Throwable th) {
                LoggerStorage.getMainPublicOrAnonymousLogger().error(th, "Got exception from processor " + moduleAdRevenueProcessor.getDescription(), new Object[0]);
            }
            if (process) {
                break;
            }
        }
        boolean z = ((ModuleAdRevenueProcessor) obj) != null;
        if (!z) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue was not processed by " + getDescription() + " since processor for " + Arrays.toString(objArr) + " was not found", new Object[0]);
        }
        return z;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder
    public final void register(ModuleAdRevenueProcessor moduleAdRevenueProcessor) {
        this.f1033a.add(moduleAdRevenueProcessor);
    }
}
