package ru.mrlargha.commonui.elements.new_container;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arizona.common.utils.EasyAnimation;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.NewContainerLayoutBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: NewContainerScreen.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/new_container/NewContainerScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/NewContainerLayoutBinding;", "awardsAdapter", "Lru/mrlargha/commonui/elements/new_container/NewContainerAwardsAdapter;", "imageCdnPath", "", "colorizeTextView", "", "textView", "Landroid/widget/TextView;", "color", "setContainerInfo", "info", "Lru/mrlargha/commonui/elements/new_container/NewContainerScreen$Companion$ContainerInfo;", "onBackendMessageHandled", "data", "subId", "Companion", "Spawner", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NewContainerScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final NewContainerAwardsAdapter awardsAdapter;
    private final NewContainerLayoutBinding binding;
    private final String imageCdnPath;
    private final ConstraintLayout layout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewContainerScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        String str;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.new_container_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        NewContainerLayoutBinding bind = NewContainerLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        NewContainerAwardsAdapter newContainerAwardsAdapter = new NewContainerAwardsAdapter();
        this.awardsAdapter = newContainerAwardsAdapter;
        if (UtilsKt.isArizonaType()) {
            str = "systems/container/";
        } else {
            str = "systems/nft_container/";
        }
        this.imageCdnPath = str;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.listAwardsPremium.setAdapter(newContainerAwardsAdapter);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        CardView actionButton = bind.actionButton;
        Intrinsics.checkNotNullExpressionValue(actionButton, "actionButton");
        EasyAnimation.animateClick$default(easyAnimation, actionButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.new_container.NewContainerScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewContainerScreen.lambda$0$0(NewContainerScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation2, exitButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.new_container.NewContainerScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewContainerScreen.lambda$0$1(NewContainerScreen.this);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(NewContainerScreen newContainerScreen) {
        SAMPUIElement.notifyClick$default(newContainerScreen, 0, 1, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(NewContainerScreen newContainerScreen) {
        SAMPUIElement.notifyClick$default(newContainerScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void colorizeTextView(TextView textView, int i) {
        String string = getTargetActivity().getString(R.string.take_container_content);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String substringAfterLast$default = StringsKt.substringAfterLast$default(string, '\n', (String) null, 2, (Object) null);
        String str = string;
        SpannableString spannableString = new SpannableString(str);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, substringAfterLast$default, 0, false, 6, (Object) null);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf$default, substringAfterLast$default.length() + indexOf$default, 33);
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
        String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        String str = this.imageCdnPath;
        picasso.load(projectResourceUrl$default + str + containerInfo.getLogo()).into(newContainerLayoutBinding.mainImageContainer);
        this.awardsAdapter.addWinnerInfo(containerInfo.getItems());
        String backgroundImage = containerInfo.getBackgroundImage();
        if (backgroundImage != null && backgroundImage.length() != 0) {
            NewContainerLayoutBinding newContainerLayoutBinding2 = this.binding;
            newContainerLayoutBinding2.blurContainer.setVisibility(4);
            Picasso picasso2 = Picasso.get();
            String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            String str2 = this.imageCdnPath;
            picasso2.load(projectResourceUrl$default2 + str2 + containerInfo.getBackgroundImage()).into(newContainerLayoutBinding2.imageBg);
        } else {
            NewContainerLayoutBinding newContainerLayoutBinding3 = this.binding;
            newContainerLayoutBinding3.imageBg.setImageDrawable(null);
            newContainerLayoutBinding3.blurContainer.setVisibility(0);
        }
        String buttonBackgroundImage = containerInfo.getButtonBackgroundImage();
        if (buttonBackgroundImage != null && buttonBackgroundImage.length() != 0) {
            NewContainerLayoutBinding newContainerLayoutBinding4 = this.binding;
            Picasso picasso3 = Picasso.get();
            String projectResourceUrl$default3 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            String str3 = this.imageCdnPath;
            picasso3.load(projectResourceUrl$default3 + str3 + containerInfo.getButtonBackgroundImage()).into(newContainerLayoutBinding4.imageButtonBg);
            newContainerLayoutBinding4.actionButtonText.setTextColor(-1);
            newContainerLayoutBinding4.actionButton.setBackgroundTintList(null);
            return;
        }
        NewContainerLayoutBinding newContainerLayoutBinding5 = this.binding;
        newContainerLayoutBinding5.imageButtonBg.setImageDrawable(null);
        newContainerLayoutBinding5.actionButtonText.setTextColor(Color.parseColor("#111111"));
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Companion.ContainerInfo containerInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i != 0 || (containerInfo = (Companion.ContainerInfo) MapperKt.jsonToModel(data, Companion.ContainerInfo.class, getBackendID(), getTargetActivity(), getNotifier())) == null) {
            return;
        }
        setContainerInfo(containerInfo);
    }

    /* compiled from: NewContainerScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/new_container/NewContainerScreen$Companion;", "", "<init>", "()V", "ContainerInfo", "AwardInfo", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: NewContainerScreen.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/new_container/NewContainerScreen$Companion$ContainerInfo;", "", "mainColor", "", "logo", "items", "", "Lru/mrlargha/commonui/elements/new_container/NewContainerScreen$Companion$AwardInfo;", "buttonBackgroundImage", "backgroundImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getMainColor", "()Ljava/lang/String;", "getLogo", "getItems", "()Ljava/util/List;", "getButtonBackgroundImage", "getBackgroundImage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class ContainerInfo {
            private final String backgroundImage;
            private final String buttonBackgroundImage;
            private final List<AwardInfo> items;
            private final String logo;
            private final String mainColor;

            public static /* synthetic */ ContainerInfo copy$default(ContainerInfo containerInfo, String str, String str2, List list, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = containerInfo.mainColor;
                }
                if ((i & 2) != 0) {
                    str2 = containerInfo.logo;
                }
                List<AwardInfo> list2 = list;
                if ((i & 4) != 0) {
                    list2 = containerInfo.items;
                }
                if ((i & 8) != 0) {
                    str3 = containerInfo.buttonBackgroundImage;
                }
                if ((i & 16) != 0) {
                    str4 = containerInfo.backgroundImage;
                }
                String str5 = str4;
                List list3 = list2;
                return containerInfo.copy(str, str2, list3, str3, str5);
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

            public final String component4() {
                return this.buttonBackgroundImage;
            }

            public final String component5() {
                return this.backgroundImage;
            }

            public final ContainerInfo copy(String mainColor, String logo, List<AwardInfo> items, String str, String str2) {
                Intrinsics.checkNotNullParameter(mainColor, "mainColor");
                Intrinsics.checkNotNullParameter(logo, "logo");
                Intrinsics.checkNotNullParameter(items, "items");
                return new ContainerInfo(mainColor, logo, items, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ContainerInfo) {
                    ContainerInfo containerInfo = (ContainerInfo) obj;
                    return Intrinsics.areEqual(this.mainColor, containerInfo.mainColor) && Intrinsics.areEqual(this.logo, containerInfo.logo) && Intrinsics.areEqual(this.items, containerInfo.items) && Intrinsics.areEqual(this.buttonBackgroundImage, containerInfo.buttonBackgroundImage) && Intrinsics.areEqual(this.backgroundImage, containerInfo.backgroundImage);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = ((((this.mainColor.hashCode() * 31) + this.logo.hashCode()) * 31) + this.items.hashCode()) * 31;
                String str = this.buttonBackgroundImage;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.backgroundImage;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                String str = this.mainColor;
                String str2 = this.logo;
                List<AwardInfo> list = this.items;
                String str3 = this.buttonBackgroundImage;
                return "ContainerInfo(mainColor=" + str + ", logo=" + str2 + ", items=" + list + ", buttonBackgroundImage=" + str3 + ", backgroundImage=" + this.backgroundImage + ")";
            }

            public ContainerInfo(String mainColor, String logo, List<AwardInfo> items, String str, String str2) {
                Intrinsics.checkNotNullParameter(mainColor, "mainColor");
                Intrinsics.checkNotNullParameter(logo, "logo");
                Intrinsics.checkNotNullParameter(items, "items");
                this.mainColor = mainColor;
                this.logo = logo;
                this.items = items;
                this.buttonBackgroundImage = str;
                this.backgroundImage = str2;
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

            public final String getButtonBackgroundImage() {
                return this.buttonBackgroundImage;
            }

            public final String getBackgroundImage() {
                return this.backgroundImage;
            }
        }

        /* compiled from: NewContainerScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/new_container/NewContainerScreen$Companion$AwardInfo;", "", "title", "", "sysName", "", "count", "<init>", "(Ljava/lang/String;II)V", "getTitle", "()Ljava/lang/String;", "getSysName", "()I", "getCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/new_container/NewContainerScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_NEW_CONTAINER);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new NewContainerScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
