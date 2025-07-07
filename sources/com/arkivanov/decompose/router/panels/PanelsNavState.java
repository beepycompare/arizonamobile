package com.arkivanov.decompose.router.panels;

import com.arkivanov.decompose.router.children.ChildNavState;
import com.arkivanov.decompose.router.children.NavState;
import com.arkivanov.decompose.router.children.SimpleChildNavState;
import com.arkivanov.decompose.router.panels.Config;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildPanelsFactory.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\n\b\u0002\u0010\u0004 \u0001*\u00020\u00022\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00060\u0005B!\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bHÆ\u0003J7\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR2\u0010\r\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00060\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/arkivanov/decompose/router/panels/PanelsNavState;", "MC", "", "DC", "EC", "Lcom/arkivanov/decompose/router/children/NavState;", "Lcom/arkivanov/decompose/router/panels/Config;", "panels", "Lcom/arkivanov/decompose/router/panels/Panels;", "<init>", "(Lcom/arkivanov/decompose/router/panels/Panels;)V", "getPanels", "()Lcom/arkivanov/decompose/router/panels/Panels;", "children", "", "Lcom/arkivanov/decompose/router/children/ChildNavState;", "getChildren", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelsNavState<MC, DC, EC> implements NavState<Config<? extends MC, ? extends DC, ? extends EC>> {
    private final List<ChildNavState<Config<MC, DC, EC>>> children;
    private final Panels<MC, DC, EC> panels;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PanelsNavState copy$default(PanelsNavState panelsNavState, Panels panels, int i, Object obj) {
        if ((i & 1) != 0) {
            panels = panelsNavState.panels;
        }
        return panelsNavState.copy(panels);
    }

    public final Panels<MC, DC, EC> component1() {
        return this.panels;
    }

    public final PanelsNavState<MC, DC, EC> copy(Panels<? extends MC, ? extends DC, ? extends EC> panels) {
        Intrinsics.checkNotNullParameter(panels, "panels");
        return new PanelsNavState<>(panels);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PanelsNavState) && Intrinsics.areEqual(this.panels, ((PanelsNavState) obj).panels);
    }

    public int hashCode() {
        return this.panels.hashCode();
    }

    public String toString() {
        return "PanelsNavState(panels=" + this.panels + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PanelsNavState(Panels<? extends MC, ? extends DC, ? extends EC> panels) {
        ChildNavState.Status status;
        SimpleChildNavState simpleChildNavState;
        ChildNavState.Status status2;
        Intrinsics.checkNotNullParameter(panels, "panels");
        this.panels = panels;
        SimpleChildNavState[] simpleChildNavStateArr = new SimpleChildNavState[3];
        Config.Main main = new Config.Main(panels.getMain());
        if (panels.getMode() != ChildPanelsMode.SINGLE) {
            status = ChildNavState.Status.RESUMED;
        } else {
            status = (panels.getDetails() == null && panels.getExtra() == null) ? ChildNavState.Status.RESUMED : ChildNavState.Status.CREATED;
        }
        simpleChildNavStateArr[0] = new SimpleChildNavState(main, status);
        Object details = panels.getDetails();
        if (details != null) {
            Config.Details details2 = new Config.Details(details);
            if (panels.getMode() == ChildPanelsMode.TRIPLE) {
                status2 = ChildNavState.Status.RESUMED;
            } else {
                status2 = panels.getExtra() == null ? ChildNavState.Status.RESUMED : ChildNavState.Status.CREATED;
            }
            simpleChildNavState = new SimpleChildNavState(details2, status2);
        } else {
            simpleChildNavState = null;
        }
        simpleChildNavStateArr[1] = simpleChildNavState;
        Object extra = panels.getExtra();
        simpleChildNavStateArr[2] = extra != null ? new SimpleChildNavState(new Config.Extra(extra), ChildNavState.Status.RESUMED) : null;
        this.children = CollectionsKt.listOfNotNull((Object[]) simpleChildNavStateArr);
    }

    public final Panels<MC, DC, EC> getPanels() {
        return this.panels;
    }

    @Override // com.arkivanov.decompose.router.children.NavState
    public List<ChildNavState<Config<MC, DC, EC>>> getChildren() {
        return this.children;
    }
}
