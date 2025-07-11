package ru.mrlargha.commonui.elements.radial_menu;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.elements.radial_menu.PieSelector;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: SelectorElement.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/SelectorElement;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "backendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "pie", "Lru/mrlargha/commonui/elements/radial_menu/PieSelector;", "onBackendMessage", "", "data", "", "subId", "submitSectorsList", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectorElement extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SelectorElement";
    private final IBackendNotifier backendNotifier;
    private final View layout;
    private final PieSelector pie;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectorElement(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View layout = LayoutInflater.from(targetActivity).inflate(R.layout.selector_element, (ViewGroup) null, false);
        this.layout = layout;
        this.backendNotifier = (IBackendNotifier) targetActivity;
        View findViewById = layout.findViewById(R.id.pie);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        PieSelector pieSelector = (PieSelector) findViewById;
        this.pie = pieSelector;
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        addViewToConstraintLayout(layout, -1, -1);
        pieSelector.setListener(new PieSelector.SectorSelectedLister() { // from class: ru.mrlargha.commonui.elements.radial_menu.SelectorElement.1
            @Override // ru.mrlargha.commonui.elements.radial_menu.PieSelector.SectorSelectedLister
            public void onSectorSelected(SectorData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                SelectorElement.this.backendNotifier.clickedWrapper(i, data.getSectorId(), -1);
                Log.d(SelectorElement.TAG, "onSectorSelected: sector: " + data);
            }

            @Override // ru.mrlargha.commonui.elements.radial_menu.PieSelector.SectorSelectedLister
            public void onCanceled() {
                SelectorElement.this.backendNotifier.clickedWrapper(i, -1, -1);
                Log.d(SelectorElement.TAG, "onCanceled: cancelled");
            }

            @Override // ru.mrlargha.commonui.elements.radial_menu.PieSelector.SectorSelectedLister
            public void onCenterClicked() {
                SelectorElement.this.backendNotifier.clickedWrapper(i, -2, -1);
                Log.d(SelectorElement.TAG, "onCenterClicked: center clicked");
            }
        });
        setVisibility(false);
    }

    /* compiled from: SelectorElement.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/SelectorElement$Companion;", "", "<init>", "()V", "TAG", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            submitSectorsList(data);
        } else if (i != 1) {
        } else {
            this.pie.updateSectorsList(MapperKt.toListModel(data, UpdateSectorData.class));
        }
    }

    private final void submitSectorsList(String str) {
        List<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            arrayList.add(StringsKt.trim((CharSequence) str2).toString());
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() <= 8 && !arrayList2.isEmpty()) {
            this.pie.setSectorsList(SectorDataKt.createSectorDataListFromActions(arrayList2));
            return;
        }
        throw new IllegalArgumentException("Count of sectors must be from 1 to 8");
    }

    /* compiled from: SelectorElement.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/SelectorElement$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new SelectorElement(targetActivity, i);
        }
    }
}
