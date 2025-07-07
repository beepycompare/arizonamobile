package ru.mrlargha.arizonaui.new_container;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.NewContainerLayoutBinding;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: NewContainerScreen.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/new_container/NewContainerScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/arizonaui/databinding/NewContainerLayoutBinding;", "awardsAdapter", "Lru/mrlargha/arizonaui/new_container/NewContainerAwardsAdapter;", "colorizeTextView", "", "textView", "Landroid/widget/TextView;", "color", "setContainerInfo", "info", "Lru/mrlargha/arizonaui/new_container/NewContainerScreen$Companion$ContainerInfo;", "onBackendMessage", "data", "", "subId", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewContainerScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final NewContainerAwardsAdapter awardsAdapter;
    private final NewContainerLayoutBinding binding;
    private final ConstraintLayout layout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewContainerScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.new_container_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        NewContainerLayoutBinding bind = NewContainerLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.awardsAdapter = new NewContainerAwardsAdapter();
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout actionButton = bind.actionButton;
        Intrinsics.checkNotNullExpressionValue(actionButton, "actionButton");
        EasyAnimation.animateClick$default(easyAnimation, actionButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.new_container.NewContainerScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewContainerScreen.lambda$2$lambda$0(NewContainerScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation2, exitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.new_container.NewContainerScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewContainerScreen.lambda$2$lambda$1(NewContainerScreen.this);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$0(NewContainerScreen newContainerScreen) {
        SAMPUIElement.notifyClick$default(newContainerScreen, 0, 1, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$1(NewContainerScreen newContainerScreen) {
        SAMPUIElement.notifyClick$default(newContainerScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void colorizeTextView(TextView textView, int i) {
        SpannableString spannableString = new SpannableString(r2);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) r2, "контейнера", 0, false, 6, (Object) null);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf$default, "контейнера".length() + indexOf$default, 33);
        textView.setText(spannableString);
    }

    private final void setContainerInfo(Companion.ContainerInfo containerInfo) {
        NewContainerLayoutBinding newContainerLayoutBinding = this.binding;
        TextView containerTitle = newContainerLayoutBinding.containerTitle;
        Intrinsics.checkNotNullExpressionValue(containerTitle, "containerTitle");
        colorizeTextView(containerTitle, Color.parseColor(containerInfo.getMainColor()));
        newContainerLayoutBinding.actionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(containerInfo.getMainColor())));
        newContainerLayoutBinding.blurContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(containerInfo.getMainColor())));
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + "projects/arizona-rp/systems/container/" + containerInfo.getLogo()).into(newContainerLayoutBinding.mainImageContainer);
        this.awardsAdapter.addWinnerInfo(containerInfo.getItems());
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Companion.ContainerInfo containerInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i != 0 || (containerInfo = (Companion.ContainerInfo) MapperKt.jsonToModel(data, Companion.ContainerInfo.class, getBackendID(), getTargetActivity(), getNotifier())) == null) {
            return;
        }
        setContainerInfo(containerInfo);
    }

    /* compiled from: NewContainerScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/new_container/NewContainerScreen$Companion;", "", "<init>", "()V", "ContainerInfo", "AwardInfo", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: NewContainerScreen.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/new_container/NewContainerScreen$Companion$ContainerInfo;", "", "mainColor", "", "logo", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/arizonaui/new_container/NewContainerScreen$Companion$AwardInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getMainColor", "()Ljava/lang/String;", "getLogo", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ContainerInfo {
            private final List<AwardInfo> items;
            private final String logo;
            private final String mainColor;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ContainerInfo copy$default(ContainerInfo containerInfo, String str, String str2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = containerInfo.mainColor;
                }
                if ((i & 2) != 0) {
                    str2 = containerInfo.logo;
                }
                if ((i & 4) != 0) {
                    list = containerInfo.items;
                }
                return containerInfo.copy(str, str2, list);
            }

            public final String component1() {
                return this.mainColor;
            }

            public final String component2() {
                return this.logo;
            }

            public final List<AwardInfo> component3() {
                return this.items;
            }

            public final ContainerInfo copy(String mainColor, String logo, List<AwardInfo> items) {
                Intrinsics.checkNotNullParameter(mainColor, "mainColor");
                Intrinsics.checkNotNullParameter(logo, "logo");
                Intrinsics.checkNotNullParameter(items, "items");
                return new ContainerInfo(mainColor, logo, items);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ContainerInfo) {
                    ContainerInfo containerInfo = (ContainerInfo) obj;
                    return Intrinsics.areEqual(this.mainColor, containerInfo.mainColor) && Intrinsics.areEqual(this.logo, containerInfo.logo) && Intrinsics.areEqual(this.items, containerInfo.items);
                }
                return false;
            }

            public int hashCode() {
                return (((this.mainColor.hashCode() * 31) + this.logo.hashCode()) * 31) + this.items.hashCode();
            }

            public String toString() {
                String str = this.mainColor;
                String str2 = this.logo;
                return "ContainerInfo(mainColor=" + str + ", logo=" + str2 + ", items=" + this.items + ")";
            }

            public ContainerInfo(String mainColor, String logo, List<AwardInfo> items) {
                Intrinsics.checkNotNullParameter(mainColor, "mainColor");
                Intrinsics.checkNotNullParameter(logo, "logo");
                Intrinsics.checkNotNullParameter(items, "items");
                this.mainColor = mainColor;
                this.logo = logo;
                this.items = items;
            }

            public final String getMainColor() {
                return this.mainColor;
            }

            public final String getLogo() {
                return this.logo;
            }

            public final List<AwardInfo> getItems() {
                return this.items;
            }
        }

        /* compiled from: NewContainerScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/new_container/NewContainerScreen$Companion$AwardInfo;", "", "title", "", "sysName", "", "count", "<init>", "(Ljava/lang/String;II)V", "getTitle", "()Ljava/lang/String;", "getSysName", "()I", "getCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AwardInfo {
            private final int count;
            private final int sysName;
            private final String title;

            public static /* synthetic */ AwardInfo copy$default(AwardInfo awardInfo, String str, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = awardInfo.title;
                }
                if ((i3 & 2) != 0) {
                    i = awardInfo.sysName;
                }
                if ((i3 & 4) != 0) {
                    i2 = awardInfo.count;
                }
                return awardInfo.copy(str, i, i2);
            }

            public final String component1() {
                return this.title;
            }

            public final int component2() {
                return this.sysName;
            }

            public final int component3() {
                return this.count;
            }

            public final AwardInfo copy(String title, int i, int i2) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new AwardInfo(title, i, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof AwardInfo) {
                    AwardInfo awardInfo = (AwardInfo) obj;
                    return Intrinsics.areEqual(this.title, awardInfo.title) && this.sysName == awardInfo.sysName && this.count == awardInfo.count;
                }
                return false;
            }

            public int hashCode() {
                return (((this.title.hashCode() * 31) + Integer.hashCode(this.sysName)) * 31) + Integer.hashCode(this.count);
            }

            public String toString() {
                String str = this.title;
                int i = this.sysName;
                return "AwardInfo(title=" + str + ", sysName=" + i + ", count=" + this.count + ")";
            }

            public AwardInfo(String title, int i, int i2) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
                this.sysName = i;
                this.count = i2;
            }

            public final String getTitle() {
                return this.title;
            }

            public final int getSysName() {
                return this.sysName;
            }

            public final int getCount() {
                return this.count;
            }
        }
    }

    /* compiled from: NewContainerScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/new_container/NewContainerScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new NewContainerScreen(targetActivity, i);
        }
    }
}
