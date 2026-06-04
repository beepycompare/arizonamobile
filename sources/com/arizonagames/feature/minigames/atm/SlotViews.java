package com.arizonagames.feature.minigames.atm;

import android.view.View;
import android.widget.ImageView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AtmScreen.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/arizonagames/feature/minigames/atm/SlotViews;", "", TtmlNode.RUBY_CONTAINER, "Landroid/view/View;", "tray", TtmlNode.TAG_BODY, "Landroid/widget/ImageView;", "bills", "", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/widget/ImageView;Ljava/util/List;)V", "getContainer", "()Landroid/view/View;", "getTray", "getBody", "()Landroid/widget/ImageView;", "getBills", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "atm"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlotViews {
    private final List<ImageView> bills;
    private final ImageView body;
    private final View container;
    private final View tray;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlotViews copy$default(SlotViews slotViews, View view, View view2, ImageView imageView, List list, int i, Object obj) {
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
            list = slotViews.bills;
        }
        return slotViews.copy(view, view2, imageView, list);
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

    public final List<ImageView> component4() {
        return this.bills;
    }

    public final SlotViews copy(View container, View tray, ImageView body, List<? extends ImageView> bills) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(tray, "tray");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(bills, "bills");
        return new SlotViews(container, tray, body, bills);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SlotViews) {
            SlotViews slotViews = (SlotViews) obj;
            return Intrinsics.areEqual(this.container, slotViews.container) && Intrinsics.areEqual(this.tray, slotViews.tray) && Intrinsics.areEqual(this.body, slotViews.body) && Intrinsics.areEqual(this.bills, slotViews.bills);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.container.hashCode() * 31) + this.tray.hashCode()) * 31) + this.body.hashCode()) * 31) + this.bills.hashCode();
    }

    public String toString() {
        View view = this.container;
        View view2 = this.tray;
        ImageView imageView = this.body;
        return "SlotViews(container=" + view + ", tray=" + view2 + ", body=" + imageView + ", bills=" + this.bills + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlotViews(View container, View tray, ImageView body, List<? extends ImageView> bills) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(tray, "tray");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(bills, "bills");
        this.container = container;
        this.tray = tray;
        this.body = body;
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

    public final List<ImageView> getBills() {
        return this.bills;
    }
}
