package ru.mrlargha.commonui.elements.hud.presentation.inner_classes;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.BannerElementBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: Banner.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement;", "", "binding", "Lru/mrlargha/commonui/databinding/BannerElementBinding;", "isArizonaType", "", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/BannerElementBinding;ZLru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/BannerElementBinding;", "()Z", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "timerr", "Landroid/os/CountDownTimer;", "setVisible", "", "data", "", "initializeBanner", "setTypeBanner", "setBannerInfo", "info", "Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement$Companion$BannerInfo;", "checkBannersType", "setDefaultType", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerElement {
    public static final Companion Companion = new Companion(null);
    private final BannerElementBinding binding;
    private final boolean isArizonaType;
    private final SAMPUIElement notifier;
    private CountDownTimer timerr;

    /* compiled from: Banner.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Companion.BannersType.values().length];
            try {
                iArr[Companion.BannersType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.BannersType.EASTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BannerElement(BannerElementBinding binding, boolean z, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.isArizonaType = z;
        this.notifier = notifier;
    }

    public final BannerElementBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final boolean isArizonaType() {
        return this.isArizonaType;
    }

    public final void setVisible(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Integer intOrNull = StringsKt.toIntOrNull(data);
        if ((intOrNull != null ? intOrNull.intValue() : 0) == 1) {
            this.binding.getRoot().setVisibility(0);
            this.binding.main.setTranslationY(-300.0f);
            this.binding.main.animate().translationY(0.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).start();
            return;
        }
        this.binding.getRoot().setVisibility(8);
    }

    public final void initializeBanner(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            setBannerInfo((Companion.BannerInfo) MapperKt.toModel(data, Companion.BannerInfo.class));
        } catch (Exception e) {
            Log.d("HUD", "initializeBannerError: " + e);
        }
    }

    public final void setTypeBanner(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        checkBannersType(data);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [ru.mrlargha.commonui.elements.hud.presentation.inner_classes.BannerElement$setBannerInfo$1$2] */
    private final void setBannerInfo(Companion.BannerInfo bannerInfo) {
        CountDownTimer countDownTimer;
        if (bannerInfo.getTimer() != 0 && (countDownTimer = this.timerr) != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timerr");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        final BannerElementBinding bannerElementBinding = this.binding;
        bannerElementBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.inner_classes.BannerElement$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerElement.setBannerInfo$lambda$1$lambda$0(BannerElement.this, view);
            }
        });
        bannerElementBinding.title.setText(bannerInfo.getTitle());
        bannerElementBinding.timerCard.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(bannerInfo.getTimerColor())));
        bannerElementBinding.buttonCard.setCardBackgroundColor(Color.parseColor(bannerInfo.getButtonColor()));
        if (this.isArizonaType) {
            Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/banner/" + bannerInfo.getImage()).into(bannerElementBinding.bgImg);
        } else {
            Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/tpevent/images/" + bannerInfo.getImage()).into(bannerElementBinding.bgImg);
        }
        int typeButton = bannerInfo.getTypeButton();
        if (typeButton == 0) {
            bannerElementBinding.buttonCard.setVisibility(0);
            bannerElementBinding.buttonText.setText(bannerInfo.getActionText());
            bannerElementBinding.buttonIc.setImageResource(R.drawable.banners_ic_join);
        } else if (typeButton == 1) {
            bannerElementBinding.buttonCard.setVisibility(0);
            bannerElementBinding.buttonText.setText(bannerInfo.getActionText());
            bannerElementBinding.buttonIc.setImageResource(R.drawable.banners_ic_gps);
        } else {
            bannerElementBinding.buttonCard.setVisibility(8);
        }
        if (bannerInfo.getTimer() == 0) {
            bannerElementBinding.timerCard.setVisibility(8);
            return;
        }
        bannerElementBinding.timerCard.setVisibility(0);
        final long timer = bannerInfo.getTimer() * 1000;
        this.timerr = new CountDownTimer(timer) { // from class: ru.mrlargha.commonui.elements.hud.presentation.inner_classes.BannerElement$setBannerInfo$1$2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                long j2;
                long j3;
                bannerElementBinding.time.setText(((j / 1000) / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + (j2 % j3));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                bannerElementBinding.time.setText("00:00");
                cancel();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBannerInfo$lambda$1$lambda$0(BannerElement bannerElement, View view) {
        SAMPUIElement.notifyClick$default(bannerElement.notifier, 63, 63, null, 4, null);
    }

    private final void checkBannersType(String str) {
        BannerElementBinding bannerElementBinding = this.binding;
        int i = WhenMappings.$EnumSwitchMapping$0[Companion.BannersType.Companion.getBannersType(Integer.parseInt(str)).ordinal()];
        if (i == 1) {
            setDefaultType();
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            bannerElementBinding.getRoot().setBackgroundResource(R.drawable.banner_easter_bg);
        }
    }

    private final void setDefaultType() {
        BannerElementBinding bannerElementBinding = this.binding;
        bannerElementBinding.timerCard.setCardBackgroundColor(Color.parseColor("#FFC700"));
        bannerElementBinding.getRoot().setBackgroundResource(R.drawable.banners_bg);
        TextView title = bannerElementBinding.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        title.setVisibility(0);
    }

    /* compiled from: Banner.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement$Companion;", "", "<init>", "()V", "BannerInfo", "BannersType", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: Banner.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement$Companion$BannerInfo;", "", "image", "", "timerColor", "buttonColor", "title", "actionText", "typeButton", "", "timer", "info", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getTimerColor", "getButtonColor", "getTitle", "getActionText", "getTypeButton", "()I", "getTimer", "getInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BannerInfo {
            private final String actionText;
            private final String buttonColor;
            private final String image;
            private final String info;
            private final int timer;
            private final String timerColor;
            private final String title;
            private final int typeButton;

            public static /* synthetic */ BannerInfo copy$default(BannerInfo bannerInfo, String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = bannerInfo.image;
                }
                if ((i3 & 2) != 0) {
                    str2 = bannerInfo.timerColor;
                }
                if ((i3 & 4) != 0) {
                    str3 = bannerInfo.buttonColor;
                }
                if ((i3 & 8) != 0) {
                    str4 = bannerInfo.title;
                }
                if ((i3 & 16) != 0) {
                    str5 = bannerInfo.actionText;
                }
                if ((i3 & 32) != 0) {
                    i = bannerInfo.typeButton;
                }
                if ((i3 & 64) != 0) {
                    i2 = bannerInfo.timer;
                }
                if ((i3 & 128) != 0) {
                    str6 = bannerInfo.info;
                }
                int i4 = i2;
                String str7 = str6;
                String str8 = str5;
                int i5 = i;
                return bannerInfo.copy(str, str2, str3, str4, str8, i5, i4, str7);
            }

            public final String component1() {
                return this.image;
            }

            public final String component2() {
                return this.timerColor;
            }

            public final String component3() {
                return this.buttonColor;
            }

            public final String component4() {
                return this.title;
            }

            public final String component5() {
                return this.actionText;
            }

            public final int component6() {
                return this.typeButton;
            }

            public final int component7() {
                return this.timer;
            }

            public final String component8() {
                return this.info;
            }

            public final BannerInfo copy(String image, String timerColor, String buttonColor, String title, String actionText, int i, int i2, String info) {
                Intrinsics.checkNotNullParameter(image, "image");
                Intrinsics.checkNotNullParameter(timerColor, "timerColor");
                Intrinsics.checkNotNullParameter(buttonColor, "buttonColor");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(actionText, "actionText");
                Intrinsics.checkNotNullParameter(info, "info");
                return new BannerInfo(image, timerColor, buttonColor, title, actionText, i, i2, info);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BannerInfo) {
                    BannerInfo bannerInfo = (BannerInfo) obj;
                    return Intrinsics.areEqual(this.image, bannerInfo.image) && Intrinsics.areEqual(this.timerColor, bannerInfo.timerColor) && Intrinsics.areEqual(this.buttonColor, bannerInfo.buttonColor) && Intrinsics.areEqual(this.title, bannerInfo.title) && Intrinsics.areEqual(this.actionText, bannerInfo.actionText) && this.typeButton == bannerInfo.typeButton && this.timer == bannerInfo.timer && Intrinsics.areEqual(this.info, bannerInfo.info);
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((((this.image.hashCode() * 31) + this.timerColor.hashCode()) * 31) + this.buttonColor.hashCode()) * 31) + this.title.hashCode()) * 31) + this.actionText.hashCode()) * 31) + Integer.hashCode(this.typeButton)) * 31) + Integer.hashCode(this.timer)) * 31) + this.info.hashCode();
            }

            public String toString() {
                String str = this.image;
                String str2 = this.timerColor;
                String str3 = this.buttonColor;
                String str4 = this.title;
                String str5 = this.actionText;
                int i = this.typeButton;
                int i2 = this.timer;
                return "BannerInfo(image=" + str + ", timerColor=" + str2 + ", buttonColor=" + str3 + ", title=" + str4 + ", actionText=" + str5 + ", typeButton=" + i + ", timer=" + i2 + ", info=" + this.info + ")";
            }

            public BannerInfo(String image, String timerColor, String buttonColor, String title, String actionText, int i, int i2, String info) {
                Intrinsics.checkNotNullParameter(image, "image");
                Intrinsics.checkNotNullParameter(timerColor, "timerColor");
                Intrinsics.checkNotNullParameter(buttonColor, "buttonColor");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(actionText, "actionText");
                Intrinsics.checkNotNullParameter(info, "info");
                this.image = image;
                this.timerColor = timerColor;
                this.buttonColor = buttonColor;
                this.title = title;
                this.actionText = actionText;
                this.typeButton = i;
                this.timer = i2;
                this.info = info;
            }

            public final String getImage() {
                return this.image;
            }

            public final String getTimerColor() {
                return this.timerColor;
            }

            public final String getButtonColor() {
                return this.buttonColor;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getActionText() {
                return this.actionText;
            }

            public final int getTypeButton() {
                return this.typeButton;
            }

            public final int getTimer() {
                return this.timer;
            }

            public final String getInfo() {
                return this.info;
            }
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: Banner.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement$Companion$BannersType;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "DEFAULT", "EASTER", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BannersType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ BannersType[] $VALUES;
            public static final C0112Companion Companion;
            public static final BannersType DEFAULT = new BannersType("DEFAULT", 0, 0);
            public static final BannersType EASTER = new BannersType("EASTER", 1, 1);
            private final int subId;

            private static final /* synthetic */ BannersType[] $values() {
                return new BannersType[]{DEFAULT, EASTER};
            }

            public static EnumEntries<BannersType> getEntries() {
                return $ENTRIES;
            }

            private BannersType(String str, int i, int i2) {
                this.subId = i2;
            }

            public final int getSubId() {
                return this.subId;
            }

            static {
                BannersType[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
                Companion = new C0112Companion(null);
            }

            /* compiled from: Banner.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement$Companion$BannersType$Companion;", "", "<init>", "()V", "getBannersType", "Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement$Companion$BannersType;", "number", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* renamed from: ru.mrlargha.commonui.elements.hud.presentation.inner_classes.BannerElement$Companion$BannersType$Companion  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0112Companion {
                public /* synthetic */ C0112Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private C0112Companion() {
                }

                public final BannersType getBannersType(int i) {
                    Object obj;
                    Iterator<E> it = BannersType.getEntries().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (i == ((BannersType) obj).getSubId()) {
                            break;
                        }
                    }
                    BannersType bannersType = (BannersType) obj;
                    return bannersType == null ? BannersType.DEFAULT : bannersType;
                }
            }

            public static BannersType valueOf(String str) {
                return (BannersType) Enum.valueOf(BannersType.class, str);
            }

            public static BannersType[] values() {
                return (BannersType[]) $VALUES.clone();
            }
        }
    }
}
