package ru.mrlargha.commonui.elements.inventory.presentation.adapter;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.InventoryIconRequest;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: InventoryIconPreloader.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryIconPreloader;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "preloadJob", "Lkotlinx/coroutines/Job;", "requestedIcons", "", "Lru/mrlargha/commonui/utils/InventoryIconRequest;", "preload", "", "items", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "preferCustomIcon", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryIconPreloader {
    private Job preloadJob;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private Set<InventoryIconRequest> requestedIcons = SetsKt.emptySet();

    public final void preload(List<InventoryItem> items, boolean z) {
        Job job;
        Intrinsics.checkNotNullParameter(items, "items");
        Set<InventoryIconRequest> inventoryIconRequests = UtilsKt.inventoryIconRequests(items, z);
        if (Intrinsics.areEqual(inventoryIconRequests, this.requestedIcons) && (job = this.preloadJob) != null && job.isActive()) {
            return;
        }
        this.requestedIcons = inventoryIconRequests;
        Job job2 = this.preloadJob;
        if (job2 != null) {
            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.preloadJob = inventoryIconRequests.isEmpty() ? null : BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new InventoryIconPreloader$preload$1(inventoryIconRequests, null), 3, null);
    }
}
