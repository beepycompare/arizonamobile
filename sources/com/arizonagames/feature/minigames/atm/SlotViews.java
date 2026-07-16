package com.arizonagames.feature.minigames.atm;

import android.view.View;
import android.widget.ImageView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AtmScreen.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/SlotViews;", "", TtmlNode.RUBY_CONTAINER, "Landroid/view/View;", "tray", TtmlNode.TAG_BODY, "Landroid/widget/ImageView;", "selectedOverlay", "bills", "", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/widget/ImageView;Landroid/view/View;Ljava/util/List;)V", "getContainer", "()Landroid/view/View;", "getTray", "getBody", "()Landroid/widget/ImageView;", "getSelectedOverlay", "getBills", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "atm"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlotViews {
    private final List<ImageView> bills;
    private final ImageView body;
    private final View container;
    private final View selectedOverlay;
    private final View tray;

    public static /* synthetic */ SlotViews copy$default(SlotViews slotViews, View view, View view2, ImageView imageView, View view3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            view = slotViews.container;
        }
        if ((i & 2) != 0) {
            view2 = slotViews.tray;
        }
        if ((i & 4) != 0) {
            imageView = slotViews.body;
        }
        if ((i & 8) != 0) {
            view3 = slotViews.selectedOverlay;
        }
        List<ImageView> list2 = list;
        if ((i & 16) != 0) {
            list2 = slotViews.bills;
        }
        List list3 = list2;
        ImageView imageView2 = imageView;
        return slotViews.copy(view, view2, imageView2, view3, list3);
    }

    public final View component1() {
        return this.container;
    }

    public final View component2() {
        return this.tray;
    }

    public final ImageView component3() {
        return this.body;
    }

    public final View component4() {
        return this.selectedOverlay;
    }

    public final List<ImageView> component5() {
        return this.bills;
    }

    public final SlotViews copy(View container, View tray, ImageView body, View view, List<? extends ImageView> bills) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(tray, "tray");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(bills, "bills");
        return new SlotViews(container, tray, body, view, bills);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SlotViews) {
            SlotViews slotViews = (SlotViews) obj;
            return Intrinsics.areEqual(this.container, slotViews.container) && Intrinsics.areEqual(this.tray, slotViews.tray) && Intrinsics.areEqual(this.body, slotViews.body) && Intrinsics.areEqual(this.selectedOverlay, slotViews.selectedOverlay) && Intrinsics.areEqual(this.bills, slotViews.bills);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.container.hashCode() * 31) + this.tray.hashCode()) * 31) + this.body.hashCode()) * 31;
        View view = this.selectedOverlay;
        return ((hashCode + (view == null ? 0 : view.hashCode())) * 31) + this.bills.hashCode();
    }

    public String toString() {
        View view = this.container;
        View view2 = this.tray;
        ImageView imageView = this.body;
        View view3 = this.selectedOverlay;
        return "SlotViews(container=" + view + ", tray=" + view2 + ", body=" + imageView + ", selectedOverlay=" + view3 + ", bills=" + this.bills + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlotViews(View container, View tray, ImageView body, View view, List<? extends ImageView> bills) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(tray, "tray");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(bills, "bills");
        this.container = container;
        this.tray = tray;
        this.body = body;
        this.selectedOverlay = view;
        this.bills = bills;
    }

    public final View getContainer() {
        return this.container;
    }

    public final View getTray() {
        return this.tray;
    }

    public final ImageView getBody() {
        return this.body;
    }

    public final View getSelectedOverlay() {
        return this.selectedOverlay;
    }

    public final List<ImageView> getBills() {
        return this.bills;
    }
}
