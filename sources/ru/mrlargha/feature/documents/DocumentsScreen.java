package ru.mrlargha.feature.documents;

import android.app.Activity;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.documents.data.ArmyInfo;
import ru.mrlargha.feature.documents.data.Demorgan;
import ru.mrlargha.feature.documents.data.DocumentsBites;
import ru.mrlargha.feature.documents.data.HeaderBlock;
import ru.mrlargha.feature.documents.data.HealthInfo;
import ru.mrlargha.feature.documents.data.InfoCommon;
import ru.mrlargha.feature.documents.data.InfoItemMain;
import ru.mrlargha.feature.documents.data.LicenseInfo;
import ru.mrlargha.feature.documents.data.LicenseItem;
import ru.mrlargha.feature.documents.data.PremiumLevel;
import ru.mrlargha.feature.documents.data.PropertyInfo;
import ru.mrlargha.feature.documents.data.PropertyItem;
import ru.mrlargha.feature.documents.data.TransportInfo;
import ru.mrlargha.feature.documents.data.TransportItem;
import ru.mrlargha.feature.documents.data.VipInfo;
import ru.mrlargha.feature.documents.data.VipStatus;
import ru.mrlargha.feature.documents.databinding.DocumentLicensesBinding;
import ru.mrlargha.feature.documents.databinding.DocumentsArmyBinding;
import ru.mrlargha.feature.documents.databinding.DocumentsHealthBinding;
import ru.mrlargha.feature.documents.databinding.DocumentsLayoutBinding;
import ru.mrlargha.feature.documents.databinding.DocumentsMainBinding;
/* compiled from: DocumentScreen.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002OPB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u000204H\u0002J8\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u0005H\u0002J\u0010\u0010B\u001a\u00020\u001d2\u0006\u00100\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020\u001d2\u0006\u00100\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u001dH\u0002J\u0010\u0010G\u001a\u00020\u001d2\u0006\u00100\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020\u001dH\u0002J\u0010\u0010J\u001a\u00020\u001d2\u0006\u00100\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020\u001dH\u0002J\u0010\u0010M\u001a\u00020\u001d2\u0006\u00100\u001a\u00020NH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lru/mrlargha/feature/documents/DocumentsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/feature/documents/databinding/DocumentsLayoutBinding;", "isShowingDocs", "emptyPhoto", "propertyResidentalAdapter", "Lru/mrlargha/feature/documents/PropertyAdapter;", "propertyComercialAdapter", "vipLevelAdapter", "Lru/mrlargha/feature/documents/VipLevelAdapter;", "vipTypeAdapter", "Lru/mrlargha/feature/documents/VipTypeAdapter;", "transportAdapter", "Lru/mrlargha/feature/documents/TransportAdapter;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "soundIdNavigation", "soundIdOther", "onBackendMessage", "", "data", "", "subId", "setBgRes", "setVisibility", "visible", "", "setTabsVisibility", "bites", "intToBitArrayMSB", "", "number", "setNavigation", "setAdapters", "navigateTo", "nav", "Lru/mrlargha/feature/documents/DocumentsScreen$Navigation;", "setMainInfo", "info", "Lru/mrlargha/feature/documents/data/InfoItemMain;", "setLicensesInfo", "licenseInfo", "Lru/mrlargha/feature/documents/data/LicenseInfo;", "setLicensesItem", "isRight", "isHasLicenses", "document", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "item", TtmlNode.RUBY_CONTAINER, "Landroid/view/View;", "showDocs", "int", "dipLicense", "setHealthInfo", "Lru/mrlargha/feature/documents/data/HealthInfo;", "setArmyInfo", "Lru/mrlargha/feature/documents/data/ArmyInfo;", "clearPropertyInfo", "setPropertyInfo", "Lru/mrlargha/feature/documents/data/PropertyInfo;", "clearVipInfo", "setVipInfo", "Lru/mrlargha/feature/documents/data/VipInfo;", "clearTransportInfo", "setTransportInfo", "Lru/mrlargha/feature/documents/data/TransportInfo;", "Navigation", "Spawner", "documents_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DocumentsScreen extends SAMPUIElement {
    private final DocumentsLayoutBinding binding;
    private final int emptyPhoto;
    private int isShowingDocs;
    private final PropertyAdapter propertyComercialAdapter;
    private final PropertyAdapter propertyResidentalAdapter;
    private final ConstraintLayout screen;
    private int soundIdNavigation;
    private int soundIdOther;
    private final SoundPool soundPool;
    private final TransportAdapter transportAdapter;
    private final VipLevelAdapter vipLevelAdapter;
    private final VipTypeAdapter vipTypeAdapter;

    /* compiled from: DocumentScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Navigation.values().length];
            try {
                iArr[Navigation.Main.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Navigation.Licenses.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Navigation.Health.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Navigation.Army.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Navigation.Property.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Navigation.Transport.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Navigation.Vip.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTabsVisibility$lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentsScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.documents_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screen = constraintLayout;
        DocumentsLayoutBinding bind = DocumentsLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.emptyPhoto = R.drawable.documents_empty_photo;
        this.propertyResidentalAdapter = new PropertyAdapter();
        this.propertyComercialAdapter = new PropertyAdapter();
        this.vipLevelAdapter = new VipLevelAdapter(new Function1() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vipLevelAdapter$lambda$0;
                vipLevelAdapter$lambda$0 = DocumentsScreen.vipLevelAdapter$lambda$0(DocumentsScreen.this, ((Integer) obj).intValue());
                return vipLevelAdapter$lambda$0;
            }
        });
        this.vipTypeAdapter = new VipTypeAdapter(new Function1() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vipTypeAdapter$lambda$0;
                vipTypeAdapter$lambda$0 = DocumentsScreen.vipTypeAdapter$lambda$0(DocumentsScreen.this, ((Integer) obj).intValue());
                return vipTypeAdapter$lambda$0;
            }
        });
        this.transportAdapter = new TransportAdapter(targetActivity.getResources().getDimension(ru.mrlargha.arizonaui.R.dimen._6sdp), targetActivity.getResources().getDimension(ru.mrlargha.arizonaui.R.dimen._10sdp));
        SoundPool build = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setContentType(4).setUsage(14).build()).build();
        this.soundPool = build;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setAdapters();
        setNavigation();
        Activity activity = targetActivity;
        this.soundIdNavigation = build.load(activity, ru.mrlargha.arizonaui.R.raw.documents_nav_buttons, 1);
        this.soundIdOther = build.load(activity, ru.mrlargha.arizonaui.R.raw.documents_other_buttons, 1);
        setBgRes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vipLevelAdapter$lambda$0(DocumentsScreen documentsScreen, int i) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        documentsScreen.notifyClick(3, 1, String.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vipTypeAdapter$lambda$0(DocumentsScreen documentsScreen, int i) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        documentsScreen.notifyClick(0, 1, String.valueOf(i));
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            switch (i) {
                case 1:
                    Integer intOrNull = StringsKt.toIntOrNull(data);
                    setTabsVisibility(intOrNull != null ? intOrNull.intValue() : 0);
                    return;
                case 2:
                    int type = ((InfoCommon) MapperKt.toModel(data, InfoCommon.class)).getType();
                    if (type == DocumentsBites.Main.getValue()) {
                        setMainInfo((InfoItemMain) MapperKt.toModel(data, InfoItemMain.class));
                        navigateTo(Navigation.Main);
                        return;
                    } else if (type == DocumentsBites.Licenses.getValue()) {
                        setLicensesInfo((LicenseInfo) MapperKt.toModel(data, LicenseInfo.class));
                        navigateTo(Navigation.Licenses);
                        return;
                    } else if (type == DocumentsBites.Health.getValue()) {
                        setHealthInfo((HealthInfo) MapperKt.toModel(data, HealthInfo.class));
                        navigateTo(Navigation.Health);
                        return;
                    } else if (type == DocumentsBites.Army.getValue()) {
                        setArmyInfo((ArmyInfo) MapperKt.toModel(data, ArmyInfo.class));
                        navigateTo(Navigation.Army);
                        return;
                    } else if (type == DocumentsBites.Property.getValue()) {
                        clearPropertyInfo();
                        setPropertyInfo((PropertyInfo) MapperKt.toModel(data, PropertyInfo.class));
                        navigateTo(Navigation.Property);
                        return;
                    } else if (type == DocumentsBites.Transport.getValue()) {
                        clearTransportInfo();
                        setTransportInfo((TransportInfo) MapperKt.toModel(data, TransportInfo.class));
                        navigateTo(Navigation.Transport);
                        return;
                    } else if (type == DocumentsBites.Vip.getValue()) {
                        clearVipInfo();
                        setVipInfo((VipInfo) MapperKt.toModel(data, VipInfo.class));
                        navigateTo(Navigation.Vip);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    int type2 = ((InfoCommon) MapperKt.toModel(data, InfoCommon.class)).getType();
                    if (type2 == DocumentsBites.Property.getValue()) {
                        setPropertyInfo((PropertyInfo) MapperKt.toModel(data, PropertyInfo.class));
                        return;
                    } else if (type2 == DocumentsBites.Transport.getValue()) {
                        setTransportInfo((TransportInfo) MapperKt.toModel(data, TransportInfo.class));
                        return;
                    } else if (type2 == DocumentsBites.Vip.getValue()) {
                        setVipInfo((VipInfo) MapperKt.toModel(data, VipInfo.class));
                        return;
                    } else {
                        return;
                    }
                case 4:
                    Integer intOrNull2 = StringsKt.toIntOrNull(data);
                    int intValue = intOrNull2 != null ? intOrNull2.intValue() : 0;
                    this.isShowingDocs = intValue;
                    showDocs(intValue);
                    return;
                case 5:
                    Integer intOrNull3 = StringsKt.toIntOrNull(data);
                    dipLicense(intOrNull3 != null ? intOrNull3.intValue() : 0);
                    return;
                case 6:
                    Integer intOrNull4 = StringsKt.toIntOrNull(data);
                    if (intOrNull4 != null) {
                        int intValue2 = intOrNull4.intValue();
                        Log.d("frontend", "onBackendMessage: " + intValue2);
                        if (intValue2 == DocumentsBites.Main.getValue()) {
                            navigateTo(Navigation.Main);
                            return;
                        } else if (intValue2 == DocumentsBites.Licenses.getValue()) {
                            navigateTo(Navigation.Licenses);
                            return;
                        } else if (intValue2 == DocumentsBites.Health.getValue()) {
                            navigateTo(Navigation.Health);
                            return;
                        } else if (intValue2 == DocumentsBites.Army.getValue()) {
                            navigateTo(Navigation.Army);
                            return;
                        } else if (intValue2 == DocumentsBites.Property.getValue()) {
                            navigateTo(Navigation.Property);
                            return;
                        } else if (intValue2 == DocumentsBites.Transport.getValue()) {
                            navigateTo(Navigation.Transport);
                            return;
                        } else if (intValue2 == DocumentsBites.Vip.getValue()) {
                            navigateTo(Navigation.Vip);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            Log.d("documents", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity().getApplicationContext(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
            getNotifier().setUIElementVisible(getBackendID(), false);
            SAMPUIElement.notifyClick$default(this, 0, 0, null, 4, null);
        }
    }

    private final void setBgRes() {
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        if (UtilsKt.isArizonaType()) {
            return;
        }
        documentsLayoutBinding.army.getRoot().setBackgroundResource(R.drawable.document_army_rodina_bg);
        documentsLayoutBinding.health.getRoot().setBackgroundResource(R.drawable.document_health_rodina_bg);
        documentsLayoutBinding.licenses.getRoot().setBackgroundResource(R.drawable.document_licenses_rodina_bg);
        documentsLayoutBinding.main.getRoot().setBackgroundResource(R.drawable.document_main_rodina_bg);
        documentsLayoutBinding.property.getRoot().setBackgroundResource(R.drawable.document_property_rodina_bg);
        documentsLayoutBinding.transport.getRoot().setBackgroundResource(R.drawable.document_transport_rodina_bg);
        documentsLayoutBinding.vip.getRoot().setBackgroundResource(R.drawable.document_vip_rodina_bg);
        TextView info = documentsLayoutBinding.army.info;
        Intrinsics.checkNotNullExpressionValue(info, "info");
        info.setVisibility(8);
        ImageView infoIc = documentsLayoutBinding.army.infoIc;
        Intrinsics.checkNotNullExpressionValue(infoIc, "infoIc");
        infoIc.setVisibility(8);
        LinearLayout reviewContainer = documentsLayoutBinding.health.reviewContainer;
        Intrinsics.checkNotNullExpressionValue(reviewContainer, "reviewContainer");
        reviewContainer.setVisibility(8);
        TextView desc = documentsLayoutBinding.health.desc;
        Intrinsics.checkNotNullExpressionValue(desc, "desc");
        desc.setVisibility(8);
        documentsLayoutBinding.licenses.boatTitle.setText("Лицензия на водный транспорт");
        documentsLayoutBinding.main.tvYearsState.setText("Лет в округе");
        TextView tvLaw = documentsLayoutBinding.main.tvLaw;
        Intrinsics.checkNotNullExpressionValue(tvLaw, "tvLaw");
        tvLaw.setVisibility(8);
        TextView lawAbiding = documentsLayoutBinding.main.lawAbiding;
        Intrinsics.checkNotNullExpressionValue(lawAbiding, "lawAbiding");
        lawAbiding.setVisibility(8);
        TextView tvArmyWrit = documentsLayoutBinding.main.tvArmyWrit;
        Intrinsics.checkNotNullExpressionValue(tvArmyWrit, "tvArmyWrit");
        tvArmyWrit.setVisibility(8);
        TextView armyWrit = documentsLayoutBinding.main.armyWrit;
        Intrinsics.checkNotNullExpressionValue(armyWrit, "armyWrit");
        armyWrit.setVisibility(8);
        TextView insurance = documentsLayoutBinding.health.insurance;
        Intrinsics.checkNotNullExpressionValue(insurance, "insurance");
        insurance.setVisibility(8);
        TextView tvInsurance = documentsLayoutBinding.health.tvInsurance;
        Intrinsics.checkNotNullExpressionValue(tvInsurance, "tvInsurance");
        tvInsurance.setVisibility(8);
        TextView tvDrugs = documentsLayoutBinding.health.tvDrugs;
        Intrinsics.checkNotNullExpressionValue(tvDrugs, "tvDrugs");
        tvDrugs.setVisibility(8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        this.soundPool.play(this.soundIdNavigation, 1.0f, 1.0f, 0, 0, 1.0f);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
    }

    private final void setTabsVisibility(int i) {
        List<Integer> intToBitArrayMSB = intToBitArrayMSB(i);
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.icHealth.setAlpha(0.2f);
        documentsLayoutBinding.icMain.setAlpha(0.2f);
        documentsLayoutBinding.icArmy.setAlpha(0.2f);
        documentsLayoutBinding.icLicenses.setAlpha(0.2f);
        documentsLayoutBinding.icProperty.setAlpha(0.2f);
        documentsLayoutBinding.icTransport.setAlpha(0.2f);
        documentsLayoutBinding.btnVip.setVisibility(4);
        documentsLayoutBinding.vipBg.setVisibility(4);
        documentsLayoutBinding.btnVip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setTabsVisibility$lambda$0$0(view);
            }
        });
        Integer num = (Integer) CollectionsKt.getOrNull(intToBitArrayMSB, 0);
        if ((num != null ? num.intValue() : 0) == 1) {
            documentsLayoutBinding.icMain.setAlpha(1.0f);
        }
        Integer num2 = (Integer) CollectionsKt.getOrNull(intToBitArrayMSB, 1);
        if ((num2 != null ? num2.intValue() : 0) == 1) {
            documentsLayoutBinding.icLicenses.setAlpha(1.0f);
        }
        Integer num3 = (Integer) CollectionsKt.getOrNull(intToBitArrayMSB, 2);
        if ((num3 != null ? num3.intValue() : 0) == 1) {
            documentsLayoutBinding.icHealth.setAlpha(1.0f);
        }
        Integer num4 = (Integer) CollectionsKt.getOrNull(intToBitArrayMSB, 3);
        if ((num4 != null ? num4.intValue() : 0) == 1) {
            documentsLayoutBinding.icArmy.setAlpha(1.0f);
        }
        Integer num5 = (Integer) CollectionsKt.getOrNull(intToBitArrayMSB, 4);
        if ((num5 != null ? num5.intValue() : 0) == 1) {
            documentsLayoutBinding.icProperty.setAlpha(1.0f);
        }
        Integer num6 = (Integer) CollectionsKt.getOrNull(intToBitArrayMSB, 5);
        if ((num6 != null ? num6.intValue() : 0) == 1) {
            documentsLayoutBinding.icTransport.setAlpha(1.0f);
        }
        Integer num7 = (Integer) CollectionsKt.getOrNull(intToBitArrayMSB, 6);
        if ((num7 != null ? num7.intValue() : 0) == 1) {
            documentsLayoutBinding.btnVip.setVisibility(0);
            documentsLayoutBinding.vipBg.setVisibility(0);
            documentsLayoutBinding.btnVip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentsScreen.setTabsVisibility$lambda$0$1(DocumentsScreen.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTabsVisibility$lambda$0$1(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Vip.getValue(), 3, null, 4, null);
    }

    private final List<Integer> intToBitArrayMSB(int i) {
        ArrayList arrayList = new ArrayList(32);
        for (int i2 = 0; i2 < 32; i2++) {
            arrayList.add(Integer.valueOf((i >> i2) & 1));
        }
        return arrayList;
    }

    private final void setNavigation() {
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.documents.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$0(view);
            }
        });
        documentsLayoutBinding.btnMain.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$1(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnLicenses.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$2(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnHealth.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$3(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnArmy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$4(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnProperty.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$5(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnTransport.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$6(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnEsc.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$0$7(DocumentsScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$1(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Main.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$2(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Licenses.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$3(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Health.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$4(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Army.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$5(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Property.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$6(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Transport.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$0$7(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, 0, 0, null, 4, null);
    }

    private final void setAdapters() {
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.property.residentalRecycleView.setAdapter(this.propertyResidentalAdapter);
        documentsLayoutBinding.property.comercialRecycleView.setAdapter(this.propertyComercialAdapter);
        documentsLayoutBinding.vip.levelRecycleView.setAdapter(this.vipLevelAdapter);
        documentsLayoutBinding.vip.typeRecycleView.setAdapter(this.vipTypeAdapter);
        documentsLayoutBinding.transport.transportRecycleView.setAdapter(this.transportAdapter);
    }

    private final void navigateTo(Navigation navigation) {
        this.soundPool.play(this.soundIdNavigation, 1.0f, 1.0f, 0, 0, 1.0f);
        this.binding.main.getRoot().setVisibility(8);
        this.binding.licenses.getRoot().setVisibility(8);
        this.binding.health.getRoot().setVisibility(8);
        this.binding.army.getRoot().setVisibility(8);
        this.binding.property.getRoot().setVisibility(8);
        this.binding.transport.getRoot().setVisibility(8);
        this.binding.vip.getRoot().setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()]) {
            case 1:
                this.binding.main.getRoot().setVisibility(0);
                return;
            case 2:
                this.binding.licenses.getRoot().setVisibility(0);
                return;
            case 3:
                this.binding.health.getRoot().setVisibility(0);
                return;
            case 4:
                this.binding.army.getRoot().setVisibility(0);
                return;
            case 5:
                this.binding.property.getRoot().setVisibility(0);
                return;
            case 6:
                this.binding.transport.getRoot().setVisibility(0);
                return;
            case 7:
                this.binding.vip.getRoot().setVisibility(0);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void setMainInfo(InfoItemMain infoItemMain) {
        int i;
        if (infoItemMain.getNot() == 1) {
            DocumentsLayoutBinding documentsLayoutBinding = this.binding;
            documentsLayoutBinding.main.notAvailableContainer.setVisibility(0);
            documentsLayoutBinding.main.gpsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentsScreen.setMainInfo$lambda$0$0(DocumentsScreen.this, view);
                }
            });
            return;
        }
        DocumentsLayoutBinding documentsLayoutBinding2 = this.binding;
        documentsLayoutBinding2.main.notAvailableContainer.setVisibility(8);
        Picasso picasso = Picasso.get();
        String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        picasso.load(resourceUrl$default + infoItemMain.getSkin_image_url()).error(this.emptyPhoto).into(documentsLayoutBinding2.main.photo);
        documentsLayoutBinding2.main.name.setText(infoItemMain.getName());
        documentsLayoutBinding2.main.sex.setText(infoItemMain.getSex());
        documentsLayoutBinding2.main.birth.setText(infoItemMain.getBirthday());
        documentsLayoutBinding2.main.citizenship.setText(infoItemMain.getCitizen());
        documentsLayoutBinding2.main.familyStatus.setText(infoItemMain.getMarried());
        documentsLayoutBinding2.main.yearsCitizen.setText(infoItemMain.getLevel());
        documentsLayoutBinding2.main.lawAbiding.setText(infoItemMain.getZakono());
        documentsLayoutBinding2.main.job.setText(infoItemMain.getJob());
        documentsLayoutBinding2.main.armyWrit.setText(infoItemMain.getAgenda());
        documentsLayoutBinding2.main.charity.setText(infoItemMain.getCharity());
        documentsLayoutBinding2.main.rank.setText(infoItemMain.getRank());
        documentsLayoutBinding2.main.series.setText(infoItemMain.getSeria());
        documentsLayoutBinding2.main.number.setText(infoItemMain.getNumber());
        documentsLayoutBinding2.main.signature.setText(infoItemMain.getSignature());
        String agenda_color = infoItemMain.getAgenda_color();
        if (agenda_color == null || agenda_color.length() == 0) {
            return;
        }
        try {
            i = Color.parseColor(infoItemMain.getAgenda_color());
        } catch (Exception unused) {
            i = -1;
        }
        documentsLayoutBinding2.main.lawAbiding.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$0$0(DocumentsScreen documentsScreen, View view) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        SAMPUIElement.notifyClick$default(documentsScreen, 0, 2, null, 4, null);
    }

    private final void setLicensesInfo(LicenseInfo licenseInfo) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        String str;
        Object obj9;
        String str2;
        Object obj10;
        Object obj11;
        String str3;
        String str4;
        Object obj12;
        String str5;
        String str6;
        Object obj13;
        Object obj14;
        String str7;
        String str8;
        Object obj15;
        String str9;
        Object obj16;
        Object obj17;
        boolean z;
        Object obj18;
        Object obj19;
        boolean z2;
        Object obj20;
        boolean z3;
        Object obj21;
        boolean z4;
        Object obj22;
        boolean z5;
        Object obj23;
        boolean z6;
        Object obj24;
        boolean z7;
        Object obj25;
        boolean z8;
        String str10;
        Object obj26;
        boolean z9;
        Object obj27;
        boolean z10;
        Object obj28;
        Object obj29;
        boolean z11;
        String str11;
        Object obj30;
        boolean z12;
        String str12;
        Object obj31;
        boolean z13;
        String str13;
        Object obj32;
        boolean z14;
        Object obj33;
        Object obj34;
        boolean z15;
        String date_text;
        String date_text2;
        String date_text3;
        String date_text4;
        String date_text5;
        String date_text6;
        String date_text7;
        String date_text8;
        String date_text9;
        String date_text10;
        String date_text11;
        String date_text12;
        String date_text13;
        String date_text14;
        String date_text15;
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        List<LicenseItem> info = licenseInfo.getInfo();
        TextView textView = documentsLayoutBinding.licenses.auto;
        List<LicenseItem> list = info;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((LicenseItem) obj).getLicense(), "car")) {
                break;
            }
        }
        LicenseItem licenseItem = (LicenseItem) obj;
        String str14 = "";
        textView.setText((licenseItem == null || (date_text15 = licenseItem.getDate_text()) == null) ? "" : date_text15);
        TextView textView2 = documentsLayoutBinding.licenses.moto;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual(((LicenseItem) obj2).getLicense(), "bike")) {
                break;
            }
        }
        LicenseItem licenseItem2 = (LicenseItem) obj2;
        textView2.setText((licenseItem2 == null || (date_text14 = licenseItem2.getDate_text()) == null) ? "" : date_text14);
        TextView textView3 = documentsLayoutBinding.licenses.flight;
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (Intrinsics.areEqual(((LicenseItem) obj3).getLicense(), "fly")) {
                break;
            }
        }
        LicenseItem licenseItem3 = (LicenseItem) obj3;
        textView3.setText((licenseItem3 == null || (date_text13 = licenseItem3.getDate_text()) == null) ? "" : date_text13);
        TextView textView4 = documentsLayoutBinding.licenses.boat;
        Iterator<T> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it4.next();
            if (Intrinsics.areEqual(((LicenseItem) obj4).getLicense(), "boat")) {
                break;
            }
        }
        LicenseItem licenseItem4 = (LicenseItem) obj4;
        textView4.setText((licenseItem4 == null || (date_text12 = licenseItem4.getDate_text()) == null) ? "" : date_text12);
        TextView textView5 = documentsLayoutBinding.licenses.gun;
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj5 = null;
                break;
            }
            obj5 = it5.next();
            if (Intrinsics.areEqual(((LicenseItem) obj5).getLicense(), "gun")) {
                break;
            }
        }
        LicenseItem licenseItem5 = (LicenseItem) obj5;
        textView5.setText((licenseItem5 == null || (date_text11 = licenseItem5.getDate_text()) == null) ? "" : date_text11);
        TextView textView6 = documentsLayoutBinding.licenses.fish;
        Iterator<T> it6 = list.iterator();
        while (true) {
            if (!it6.hasNext()) {
                obj6 = null;
                break;
            }
            obj6 = it6.next();
            if (Intrinsics.areEqual(((LicenseItem) obj6).getLicense(), "fish")) {
                break;
            }
        }
        LicenseItem licenseItem6 = (LicenseItem) obj6;
        textView6.setText((licenseItem6 == null || (date_text10 = licenseItem6.getDate_text()) == null) ? "" : date_text10);
        TextView textView7 = documentsLayoutBinding.licenses.hunt;
        Iterator<T> it7 = list.iterator();
        while (true) {
            if (!it7.hasNext()) {
                obj7 = null;
                break;
            }
            obj7 = it7.next();
            if (Intrinsics.areEqual(((LicenseItem) obj7).getLicense(), "hunter")) {
                break;
            }
        }
        LicenseItem licenseItem7 = (LicenseItem) obj7;
        textView7.setText((licenseItem7 == null || (date_text9 = licenseItem7.getDate_text()) == null) ? "" : date_text9);
        TextView textView8 = documentsLayoutBinding.licenses.shave;
        Iterator<T> it8 = list.iterator();
        while (true) {
            if (!it8.hasNext()) {
                obj8 = null;
                break;
            }
            obj8 = it8.next();
            if (Intrinsics.areEqual(((LicenseItem) obj8).getLicense(), "hitch")) {
                break;
            }
        }
        LicenseItem licenseItem8 = (LicenseItem) obj8;
        textView8.setText((licenseItem8 == null || (date_text8 = licenseItem8.getDate_text()) == null) ? "" : date_text8);
        TextView textView9 = documentsLayoutBinding.licenses.taxi;
        Iterator<T> it9 = list.iterator();
        while (true) {
            str = "taxi";
            if (!it9.hasNext()) {
                obj9 = null;
                break;
            }
            obj9 = it9.next();
            if (Intrinsics.areEqual(((LicenseItem) obj9).getLicense(), "taxi")) {
                break;
            }
        }
        LicenseItem licenseItem9 = (LicenseItem) obj9;
        textView9.setText((licenseItem9 == null || (date_text7 = licenseItem9.getDate_text()) == null) ? "" : date_text7);
        TextView textView10 = documentsLayoutBinding.licenses.mech;
        Iterator<T> it10 = list.iterator();
        while (true) {
            if (!it10.hasNext()) {
                str2 = str14;
                obj10 = null;
                break;
            }
            obj10 = it10.next();
            str2 = str14;
            if (Intrinsics.areEqual(((LicenseItem) obj10).getLicense(), "mechanic")) {
                break;
            }
            str14 = str2;
        }
        LicenseItem licenseItem10 = (LicenseItem) obj10;
        textView10.setText((licenseItem10 == null || (date_text6 = licenseItem10.getDate_text()) == null) ? str2 : date_text6);
        TextView textView11 = documentsLayoutBinding.licenses.advocate;
        Iterator it11 = list.iterator();
        while (true) {
            if (!it11.hasNext()) {
                obj11 = null;
                break;
            }
            obj11 = it11.next();
            Iterator it12 = it11;
            if (Intrinsics.areEqual(((LicenseItem) obj11).getLicense(), "lawyer")) {
                break;
            }
            it11 = it12;
        }
        LicenseItem licenseItem11 = (LicenseItem) obj11;
        textView11.setText((licenseItem11 == null || (date_text5 = licenseItem11.getDate_text()) == null) ? str2 : date_text5);
        TextView textView12 = documentsLayoutBinding.licenses.tax;
        Iterator it13 = list.iterator();
        while (true) {
            str3 = str;
            str4 = "taxman";
            if (!it13.hasNext()) {
                obj12 = null;
                break;
            }
            obj12 = it13.next();
            Iterator it14 = it13;
            if (Intrinsics.areEqual(((LicenseItem) obj12).getLicense(), "taxman")) {
                break;
            }
            str = str3;
            it13 = it14;
        }
        LicenseItem licenseItem12 = (LicenseItem) obj12;
        textView12.setText((licenseItem12 == null || (date_text4 = licenseItem12.getDate_text()) == null) ? str2 : date_text4);
        TextView textView13 = documentsLayoutBinding.licenses.dipl;
        Iterator it15 = list.iterator();
        while (true) {
            str5 = str4;
            str6 = "diplomat";
            if (!it15.hasNext()) {
                obj13 = null;
                break;
            }
            obj13 = it15.next();
            Iterator it16 = it15;
            if (Intrinsics.areEqual(((LicenseItem) obj13).getLicense(), "diplomat")) {
                break;
            }
            str4 = str5;
            it15 = it16;
        }
        LicenseItem licenseItem13 = (LicenseItem) obj13;
        textView13.setText((licenseItem13 == null || (r1 = licenseItem13.getDate_text()) == null) ? "Отсутствует" : "Отсутствует");
        TextView textView14 = documentsLayoutBinding.licenses.diplTop;
        Iterator it17 = list.iterator();
        while (true) {
            if (!it17.hasNext()) {
                obj14 = null;
                break;
            }
            obj14 = it17.next();
            Iterator it18 = it17;
            if (Intrinsics.areEqual(((LicenseItem) obj14).getLicense(), "diplomat")) {
                break;
            }
            it17 = it18;
        }
        LicenseItem licenseItem14 = (LicenseItem) obj14;
        textView14.setText((licenseItem14 == null || (date_text3 = licenseItem14.getDate_text()) == null) ? str2 : date_text3);
        TextView textView15 = documentsLayoutBinding.licenses.miner;
        Iterator it19 = list.iterator();
        while (true) {
            str7 = str6;
            str8 = "resource";
            if (!it19.hasNext()) {
                obj15 = null;
                break;
            }
            obj15 = it19.next();
            Iterator it20 = it19;
            if (Intrinsics.areEqual(((LicenseItem) obj15).getLicense(), "resource")) {
                break;
            }
            str6 = str7;
            it19 = it20;
        }
        LicenseItem licenseItem15 = (LicenseItem) obj15;
        textView15.setText((licenseItem15 == null || (date_text2 = licenseItem15.getDate_text()) == null) ? str2 : date_text2);
        TextView textView16 = documentsLayoutBinding.licenses.trolleybus;
        Iterator it21 = list.iterator();
        while (true) {
            str9 = str8;
            if (!it21.hasNext()) {
                obj16 = null;
                break;
            }
            obj16 = it21.next();
            Iterator it22 = it21;
            if (Intrinsics.areEqual(((LicenseItem) obj16).getLicense(), "railway")) {
                break;
            }
            str8 = str9;
            it21 = it22;
        }
        LicenseItem licenseItem16 = (LicenseItem) obj16;
        textView16.setText((licenseItem16 == null || (date_text = licenseItem16.getDate_text()) == null) ? str2 : date_text);
        DocumentLicensesBinding documentLicensesBinding = documentsLayoutBinding.licenses;
        Iterator it23 = list.iterator();
        while (true) {
            if (!it23.hasNext()) {
                obj17 = null;
                break;
            }
            obj17 = it23.next();
            Iterator it24 = it23;
            if (Intrinsics.areEqual(((LicenseItem) obj17).getLicense(), "car")) {
                break;
            }
            it23 = it24;
        }
        LicenseItem licenseItem17 = (LicenseItem) obj17;
        boolean z16 = false;
        if ((licenseItem17 != null ? licenseItem17.getAvailable() : 0) == 1) {
            z = false;
            z16 = true;
        } else {
            z = false;
        }
        boolean z17 = list instanceof Collection;
        if (z17 && list.isEmpty()) {
            obj18 = "lawyer";
        } else {
            Iterator<T> it25 = list.iterator();
            while (true) {
                if (!it25.hasNext()) {
                    obj18 = "lawyer";
                    z = false;
                    break;
                } else if (Intrinsics.areEqual(((LicenseItem) it25.next()).getLicense(), "car")) {
                    obj18 = "lawyer";
                    z = true;
                    break;
                }
            }
        }
        ImageView documentsIcAuto = documentLicensesBinding.documentsIcAuto;
        boolean z18 = z16;
        Intrinsics.checkNotNullExpressionValue(documentsIcAuto, "documentsIcAuto");
        Object obj35 = obj18;
        TextView autoTitle = documentLicensesBinding.autoTitle;
        Intrinsics.checkNotNullExpressionValue(autoTitle, "autoTitle");
        TextView auto = documentLicensesBinding.auto;
        Intrinsics.checkNotNullExpressionValue(auto, "auto");
        LinearLayout autoContainer = documentLicensesBinding.autoContainer;
        Intrinsics.checkNotNullExpressionValue(autoContainer, "autoContainer");
        Object obj36 = "railway";
        Object obj37 = obj35;
        setLicensesItem(z18, z, documentsIcAuto, autoTitle, auto, autoContainer);
        Iterator<T> it26 = list.iterator();
        while (true) {
            if (!it26.hasNext()) {
                obj19 = null;
                break;
            }
            obj19 = it26.next();
            if (Intrinsics.areEqual(((LicenseItem) obj19).getLicense(), "bike")) {
                break;
            }
        }
        LicenseItem licenseItem18 = (LicenseItem) obj19;
        boolean z19 = (licenseItem18 != null ? licenseItem18.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem19 : list) {
                if (Intrinsics.areEqual(licenseItem19.getLicense(), "bike")) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        ImageView documentsIcMoto = documentLicensesBinding.documentsIcMoto;
        Intrinsics.checkNotNullExpressionValue(documentsIcMoto, "documentsIcMoto");
        TextView motoTitle = documentLicensesBinding.motoTitle;
        Intrinsics.checkNotNullExpressionValue(motoTitle, "motoTitle");
        TextView moto = documentLicensesBinding.moto;
        Intrinsics.checkNotNullExpressionValue(moto, "moto");
        LinearLayout motoContainer = documentLicensesBinding.motoContainer;
        Intrinsics.checkNotNullExpressionValue(motoContainer, "motoContainer");
        setLicensesItem(z19, z2, documentsIcMoto, motoTitle, moto, motoContainer);
        Iterator<T> it27 = list.iterator();
        while (true) {
            if (!it27.hasNext()) {
                obj20 = null;
                break;
            }
            obj20 = it27.next();
            if (Intrinsics.areEqual(((LicenseItem) obj20).getLicense(), "fly")) {
                break;
            }
        }
        LicenseItem licenseItem20 = (LicenseItem) obj20;
        boolean z20 = (licenseItem20 != null ? licenseItem20.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem21 : list) {
                if (Intrinsics.areEqual(licenseItem21.getLicense(), "fly")) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        ImageView documentsIcFlight = documentLicensesBinding.documentsIcFlight;
        Intrinsics.checkNotNullExpressionValue(documentsIcFlight, "documentsIcFlight");
        TextView flightTitle = documentLicensesBinding.flightTitle;
        Intrinsics.checkNotNullExpressionValue(flightTitle, "flightTitle");
        TextView flight = documentLicensesBinding.flight;
        Intrinsics.checkNotNullExpressionValue(flight, "flight");
        LinearLayout flightContainer = documentLicensesBinding.flightContainer;
        Intrinsics.checkNotNullExpressionValue(flightContainer, "flightContainer");
        setLicensesItem(z20, z3, documentsIcFlight, flightTitle, flight, flightContainer);
        Iterator<T> it28 = list.iterator();
        while (true) {
            if (!it28.hasNext()) {
                obj21 = null;
                break;
            }
            obj21 = it28.next();
            if (Intrinsics.areEqual(((LicenseItem) obj21).getLicense(), "boat")) {
                break;
            }
        }
        LicenseItem licenseItem22 = (LicenseItem) obj21;
        boolean z21 = (licenseItem22 != null ? licenseItem22.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem23 : list) {
                if (Intrinsics.areEqual(licenseItem23.getLicense(), "boat")) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        ImageView documentsIcBoat = documentLicensesBinding.documentsIcBoat;
        Intrinsics.checkNotNullExpressionValue(documentsIcBoat, "documentsIcBoat");
        TextView boatTitle = documentLicensesBinding.boatTitle;
        Intrinsics.checkNotNullExpressionValue(boatTitle, "boatTitle");
        TextView boat = documentLicensesBinding.boat;
        Intrinsics.checkNotNullExpressionValue(boat, "boat");
        LinearLayout boatContainer = documentLicensesBinding.boatContainer;
        Intrinsics.checkNotNullExpressionValue(boatContainer, "boatContainer");
        setLicensesItem(z21, z4, documentsIcBoat, boatTitle, boat, boatContainer);
        Iterator<T> it29 = list.iterator();
        while (true) {
            if (!it29.hasNext()) {
                obj22 = null;
                break;
            }
            obj22 = it29.next();
            if (Intrinsics.areEqual(((LicenseItem) obj22).getLicense(), "gun")) {
                break;
            }
        }
        LicenseItem licenseItem24 = (LicenseItem) obj22;
        boolean z22 = (licenseItem24 != null ? licenseItem24.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem25 : list) {
                if (Intrinsics.areEqual(licenseItem25.getLicense(), "gun")) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        ImageView documentsIcGun = documentLicensesBinding.documentsIcGun;
        Intrinsics.checkNotNullExpressionValue(documentsIcGun, "documentsIcGun");
        TextView gunTitle = documentLicensesBinding.gunTitle;
        Intrinsics.checkNotNullExpressionValue(gunTitle, "gunTitle");
        TextView gun = documentLicensesBinding.gun;
        Intrinsics.checkNotNullExpressionValue(gun, "gun");
        LinearLayout gunContainer = documentLicensesBinding.gunContainer;
        Intrinsics.checkNotNullExpressionValue(gunContainer, "gunContainer");
        setLicensesItem(z22, z5, documentsIcGun, gunTitle, gun, gunContainer);
        Iterator<T> it30 = list.iterator();
        while (true) {
            if (!it30.hasNext()) {
                obj23 = null;
                break;
            }
            obj23 = it30.next();
            if (Intrinsics.areEqual(((LicenseItem) obj23).getLicense(), "fish")) {
                break;
            }
        }
        LicenseItem licenseItem26 = (LicenseItem) obj23;
        boolean z23 = (licenseItem26 != null ? licenseItem26.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem27 : list) {
                if (Intrinsics.areEqual(licenseItem27.getLicense(), "fish")) {
                    z6 = true;
                    break;
                }
            }
        }
        z6 = false;
        ImageView documentsIcFish = documentLicensesBinding.documentsIcFish;
        Intrinsics.checkNotNullExpressionValue(documentsIcFish, "documentsIcFish");
        TextView fishTitle = documentLicensesBinding.fishTitle;
        Intrinsics.checkNotNullExpressionValue(fishTitle, "fishTitle");
        TextView fish = documentLicensesBinding.fish;
        Intrinsics.checkNotNullExpressionValue(fish, "fish");
        LinearLayout fishContainer = documentLicensesBinding.fishContainer;
        Intrinsics.checkNotNullExpressionValue(fishContainer, "fishContainer");
        setLicensesItem(z23, z6, documentsIcFish, fishTitle, fish, fishContainer);
        Iterator<T> it31 = list.iterator();
        while (true) {
            if (!it31.hasNext()) {
                obj24 = null;
                break;
            }
            obj24 = it31.next();
            if (Intrinsics.areEqual(((LicenseItem) obj24).getLicense(), "hunter")) {
                break;
            }
        }
        LicenseItem licenseItem28 = (LicenseItem) obj24;
        boolean z24 = (licenseItem28 != null ? licenseItem28.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem29 : list) {
                if (Intrinsics.areEqual(licenseItem29.getLicense(), "hunter")) {
                    z7 = true;
                    break;
                }
            }
        }
        z7 = false;
        ImageView documentsIcHunt = documentLicensesBinding.documentsIcHunt;
        Intrinsics.checkNotNullExpressionValue(documentsIcHunt, "documentsIcHunt");
        TextView huntTitle = documentLicensesBinding.huntTitle;
        Intrinsics.checkNotNullExpressionValue(huntTitle, "huntTitle");
        TextView hunt = documentLicensesBinding.hunt;
        Intrinsics.checkNotNullExpressionValue(hunt, "hunt");
        LinearLayout huntContainer = documentLicensesBinding.huntContainer;
        Intrinsics.checkNotNullExpressionValue(huntContainer, "huntContainer");
        setLicensesItem(z24, z7, documentsIcHunt, huntTitle, hunt, huntContainer);
        Iterator<T> it32 = list.iterator();
        while (true) {
            if (!it32.hasNext()) {
                obj25 = null;
                break;
            }
            obj25 = it32.next();
            if (Intrinsics.areEqual(((LicenseItem) obj25).getLicense(), "hitch")) {
                break;
            }
        }
        LicenseItem licenseItem30 = (LicenseItem) obj25;
        boolean z25 = (licenseItem30 != null ? licenseItem30.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem31 : list) {
                if (Intrinsics.areEqual(licenseItem31.getLicense(), "hitch")) {
                    z8 = true;
                    break;
                }
            }
        }
        z8 = false;
        ImageView documentsIcShave = documentLicensesBinding.documentsIcShave;
        Intrinsics.checkNotNullExpressionValue(documentsIcShave, "documentsIcShave");
        TextView shaveTitle = documentLicensesBinding.shaveTitle;
        Intrinsics.checkNotNullExpressionValue(shaveTitle, "shaveTitle");
        TextView shave = documentLicensesBinding.shave;
        Intrinsics.checkNotNullExpressionValue(shave, "shave");
        LinearLayout shaveContainer = documentLicensesBinding.shaveContainer;
        Intrinsics.checkNotNullExpressionValue(shaveContainer, "shaveContainer");
        setLicensesItem(z25, z8, documentsIcShave, shaveTitle, shave, shaveContainer);
        Iterator<T> it33 = list.iterator();
        while (true) {
            if (!it33.hasNext()) {
                str10 = str3;
                obj26 = null;
                break;
            }
            obj26 = it33.next();
            str10 = str3;
            if (Intrinsics.areEqual(((LicenseItem) obj26).getLicense(), str10)) {
                break;
            }
            str3 = str10;
        }
        LicenseItem licenseItem32 = (LicenseItem) obj26;
        boolean z26 = (licenseItem32 != null ? licenseItem32.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem33 : list) {
                if (Intrinsics.areEqual(licenseItem33.getLicense(), str10)) {
                    z9 = true;
                    break;
                }
            }
        }
        z9 = false;
        ImageView documentsIcTaxi = documentLicensesBinding.documentsIcTaxi;
        Intrinsics.checkNotNullExpressionValue(documentsIcTaxi, "documentsIcTaxi");
        TextView taxiTitle = documentLicensesBinding.taxiTitle;
        Intrinsics.checkNotNullExpressionValue(taxiTitle, "taxiTitle");
        TextView textView17 = documentLicensesBinding.taxi;
        Intrinsics.checkNotNullExpressionValue(textView17, str10);
        LinearLayout taxiContainer = documentLicensesBinding.taxiContainer;
        Intrinsics.checkNotNullExpressionValue(taxiContainer, "taxiContainer");
        setLicensesItem(z26, z9, documentsIcTaxi, taxiTitle, textView17, taxiContainer);
        Iterator<T> it34 = list.iterator();
        while (true) {
            if (!it34.hasNext()) {
                obj27 = null;
                break;
            }
            obj27 = it34.next();
            if (Intrinsics.areEqual(((LicenseItem) obj27).getLicense(), "mechanic")) {
                break;
            }
        }
        LicenseItem licenseItem34 = (LicenseItem) obj27;
        boolean z27 = (licenseItem34 != null ? licenseItem34.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem35 : list) {
                if (Intrinsics.areEqual(licenseItem35.getLicense(), "mechanic")) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        ImageView documentsIcMech = documentLicensesBinding.documentsIcMech;
        Intrinsics.checkNotNullExpressionValue(documentsIcMech, "documentsIcMech");
        TextView mechTitle = documentLicensesBinding.mechTitle;
        Intrinsics.checkNotNullExpressionValue(mechTitle, "mechTitle");
        TextView mech = documentLicensesBinding.mech;
        Intrinsics.checkNotNullExpressionValue(mech, "mech");
        LinearLayout mechContainer = documentLicensesBinding.mechContainer;
        Intrinsics.checkNotNullExpressionValue(mechContainer, "mechContainer");
        setLicensesItem(z27, z10, documentsIcMech, mechTitle, mech, mechContainer);
        Iterator<T> it35 = list.iterator();
        while (true) {
            if (!it35.hasNext()) {
                obj28 = obj37;
                obj29 = null;
                break;
            }
            obj29 = it35.next();
            obj28 = obj37;
            if (Intrinsics.areEqual(((LicenseItem) obj29).getLicense(), obj28)) {
                break;
            }
            obj37 = obj28;
        }
        LicenseItem licenseItem36 = (LicenseItem) obj29;
        boolean z28 = (licenseItem36 != null ? licenseItem36.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem37 : list) {
                if (Intrinsics.areEqual(licenseItem37.getLicense(), obj28)) {
                    z11 = true;
                    break;
                }
            }
        }
        z11 = false;
        ImageView documentsIcAdvocate = documentLicensesBinding.documentsIcAdvocate;
        Intrinsics.checkNotNullExpressionValue(documentsIcAdvocate, "documentsIcAdvocate");
        TextView advocateTitle = documentLicensesBinding.advocateTitle;
        Intrinsics.checkNotNullExpressionValue(advocateTitle, "advocateTitle");
        TextView advocate = documentLicensesBinding.advocate;
        Intrinsics.checkNotNullExpressionValue(advocate, "advocate");
        LinearLayout advocateContainer = documentLicensesBinding.advocateContainer;
        Intrinsics.checkNotNullExpressionValue(advocateContainer, "advocateContainer");
        setLicensesItem(z28, z11, documentsIcAdvocate, advocateTitle, advocate, advocateContainer);
        Iterator<T> it36 = list.iterator();
        while (true) {
            if (!it36.hasNext()) {
                str11 = str5;
                obj30 = null;
                break;
            }
            obj30 = it36.next();
            str11 = str5;
            if (Intrinsics.areEqual(((LicenseItem) obj30).getLicense(), str11)) {
                break;
            }
            str5 = str11;
        }
        LicenseItem licenseItem38 = (LicenseItem) obj30;
        boolean z29 = (licenseItem38 != null ? licenseItem38.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem39 : list) {
                if (Intrinsics.areEqual(licenseItem39.getLicense(), str11)) {
                    z12 = true;
                    break;
                }
            }
        }
        z12 = false;
        ImageView documentsIcTax = documentLicensesBinding.documentsIcTax;
        Intrinsics.checkNotNullExpressionValue(documentsIcTax, "documentsIcTax");
        TextView taxTitle = documentLicensesBinding.taxTitle;
        Intrinsics.checkNotNullExpressionValue(taxTitle, "taxTitle");
        TextView tax = documentLicensesBinding.tax;
        Intrinsics.checkNotNullExpressionValue(tax, "tax");
        LinearLayout taxContainer = documentLicensesBinding.taxContainer;
        Intrinsics.checkNotNullExpressionValue(taxContainer, "taxContainer");
        setLicensesItem(z29, z12, documentsIcTax, taxTitle, tax, taxContainer);
        Iterator<T> it37 = list.iterator();
        while (true) {
            if (!it37.hasNext()) {
                str12 = str7;
                obj31 = null;
                break;
            }
            obj31 = it37.next();
            str12 = str7;
            if (Intrinsics.areEqual(((LicenseItem) obj31).getLicense(), str12)) {
                break;
            }
            str7 = str12;
        }
        LicenseItem licenseItem40 = (LicenseItem) obj31;
        boolean z30 = (licenseItem40 != null ? licenseItem40.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem41 : list) {
                if (Intrinsics.areEqual(licenseItem41.getLicense(), str12)) {
                    z13 = true;
                    break;
                }
            }
        }
        z13 = false;
        ImageView documentsIcDipl = documentLicensesBinding.documentsIcDipl;
        Intrinsics.checkNotNullExpressionValue(documentsIcDipl, "documentsIcDipl");
        TextView diplTitle = documentLicensesBinding.diplTitle;
        Intrinsics.checkNotNullExpressionValue(diplTitle, "diplTitle");
        TextView dipl = documentLicensesBinding.dipl;
        Intrinsics.checkNotNullExpressionValue(dipl, "dipl");
        LinearLayout diplContainerColumn = documentLicensesBinding.diplContainerColumn;
        Intrinsics.checkNotNullExpressionValue(diplContainerColumn, "diplContainerColumn");
        setLicensesItem(z30, z13, documentsIcDipl, diplTitle, dipl, diplContainerColumn);
        Iterator<T> it38 = list.iterator();
        while (true) {
            if (!it38.hasNext()) {
                str13 = str9;
                obj32 = null;
                break;
            }
            obj32 = it38.next();
            str13 = str9;
            if (Intrinsics.areEqual(((LicenseItem) obj32).getLicense(), str13)) {
                break;
            }
            str9 = str13;
        }
        LicenseItem licenseItem42 = (LicenseItem) obj32;
        boolean z31 = (licenseItem42 != null ? licenseItem42.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem43 : list) {
                if (Intrinsics.areEqual(licenseItem43.getLicense(), str13)) {
                    z14 = true;
                    break;
                }
            }
        }
        z14 = false;
        ImageView documentsIcMiner = documentLicensesBinding.documentsIcMiner;
        Intrinsics.checkNotNullExpressionValue(documentsIcMiner, "documentsIcMiner");
        TextView minerTitle = documentLicensesBinding.minerTitle;
        Intrinsics.checkNotNullExpressionValue(minerTitle, "minerTitle");
        TextView miner = documentLicensesBinding.miner;
        Intrinsics.checkNotNullExpressionValue(miner, "miner");
        LinearLayout minerContainer = documentLicensesBinding.minerContainer;
        Intrinsics.checkNotNullExpressionValue(minerContainer, "minerContainer");
        setLicensesItem(z31, z14, documentsIcMiner, minerTitle, miner, minerContainer);
        Iterator<T> it39 = list.iterator();
        while (true) {
            if (!it39.hasNext()) {
                obj33 = obj36;
                obj34 = null;
                break;
            }
            Object next = it39.next();
            obj33 = obj36;
            if (Intrinsics.areEqual(((LicenseItem) next).getLicense(), obj33)) {
                obj34 = next;
                break;
            }
            obj36 = obj33;
        }
        LicenseItem licenseItem44 = (LicenseItem) obj34;
        boolean z32 = (licenseItem44 != null ? licenseItem44.getAvailable() : 0) == 1;
        if (!z17 || !list.isEmpty()) {
            for (LicenseItem licenseItem45 : list) {
                if (Intrinsics.areEqual(licenseItem45.getLicense(), obj33)) {
                    z15 = true;
                    break;
                }
            }
        }
        z15 = false;
        ImageView documentsIcTrolleybus = documentLicensesBinding.documentsIcTrolleybus;
        Intrinsics.checkNotNullExpressionValue(documentsIcTrolleybus, "documentsIcTrolleybus");
        TextView trolleybusTitle = documentLicensesBinding.trolleybusTitle;
        Intrinsics.checkNotNullExpressionValue(trolleybusTitle, "trolleybusTitle");
        TextView trolleybus = documentLicensesBinding.trolleybus;
        Intrinsics.checkNotNullExpressionValue(trolleybus, "trolleybus");
        LinearLayout trolleybusContainer = documentLicensesBinding.trolleybusContainer;
        Intrinsics.checkNotNullExpressionValue(trolleybusContainer, "trolleybusContainer");
        setLicensesItem(z32, z15, documentsIcTrolleybus, trolleybusTitle, trolleybus, trolleybusContainer);
        if (UtilsKt.isArizonaType()) {
            return;
        }
        TextView containerDescription = documentsLayoutBinding.licenses.containerDescription;
        Intrinsics.checkNotNullExpressionValue(containerDescription, "containerDescription");
        containerDescription.setVisibility(0);
    }

    private final void showDocs(int i) {
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        if (i == 0) {
            DocumentsMainBinding documentsMainBinding = documentsLayoutBinding.main;
            documentsMainBinding.documentsMainDesc.setText("У вас нет пасспорта. Вы можете оформить его в Мэрии штата. Используйте кнопку снизу, чтобы отметить Мэрию на GPS.");
            documentsMainBinding.gpsButton.setVisibility(0);
            DocumentLicensesBinding documentLicensesBinding = documentsLayoutBinding.licenses;
            documentsLayoutBinding.licenses.containerDescription.setVisibility(0);
            DocumentsHealthBinding documentsHealthBinding = documentsLayoutBinding.health;
            if (UtilsKt.isArizonaType()) {
                documentsHealthBinding.reviewContainer.setVisibility(0);
                documentsHealthBinding.desc.setVisibility(0);
            }
            documentsHealthBinding.gpsButton.setVisibility(0);
            documentsHealthBinding.descText.setText("У вас нет мед.карты. Вы можете оформить ее в любой больнице штата. Используйте кнопку ниже, чтобы отметить на GPS ближайшую больницу.");
            DocumentsArmyBinding documentsArmyBinding = documentsLayoutBinding.army;
            if (UtilsKt.isArizonaType()) {
                documentsArmyBinding.info.setVisibility(0);
                documentsArmyBinding.infoIc.setVisibility(0);
            }
            documentsArmyBinding.emptyDescText.setText("У вас нет военного билета. Его можно получить при прохождении военной службы в Армии LS, SF или Тюрьме строгого режима, а также купить в донат-меню.");
            return;
        }
        DocumentsMainBinding documentsMainBinding2 = documentsLayoutBinding.main;
        documentsMainBinding2.documentsMainDesc.setText("У игрока отсутствует паспорт. Вы можете напомнить ему о необходимости получения паспорта в Мэрии штата.");
        documentsMainBinding2.gpsButton.setVisibility(8);
        DocumentLicensesBinding documentLicensesBinding2 = documentsLayoutBinding.licenses;
        documentsLayoutBinding.licenses.containerDescription.setVisibility(8);
        DocumentsHealthBinding documentsHealthBinding2 = documentsLayoutBinding.health;
        documentsHealthBinding2.reviewContainer.setVisibility(8);
        documentsHealthBinding2.desc.setVisibility(8);
        documentsHealthBinding2.gpsButton.setVisibility(8);
        documentsHealthBinding2.descText.setText("У игрока отсутствует мед. карта. Вы можете напомнить ему о необходимости ее получения в любой больнице штата.");
        DocumentsArmyBinding documentsArmyBinding2 = documentsLayoutBinding.army;
        documentsArmyBinding2.info.setVisibility(8);
        documentsArmyBinding2.infoIc.setVisibility(8);
        documentsArmyBinding2.emptyDescText.setText("У игрока отсутствует военный билет. Вы можете напомнить ему о необходимости прохождения военной службы.");
    }

    private final void dipLicense(int i) {
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        if (i == 1) {
            documentsLayoutBinding.licenses.containerDescription.setVisibility(8);
            documentsLayoutBinding.licenses.diplContainerTop.setVisibility(0);
            documentsLayoutBinding.licenses.diplContainerColumn.setVisibility(8);
            return;
        }
        documentsLayoutBinding.licenses.diplContainerTop.setVisibility(8);
        documentsLayoutBinding.licenses.diplContainerColumn.setVisibility(0);
    }

    private final void setHealthInfo(HealthInfo healthInfo) {
        int i;
        if (healthInfo.getNot() == 1) {
            DocumentsLayoutBinding documentsLayoutBinding = this.binding;
            documentsLayoutBinding.health.notAvailableContainer.setVisibility(0);
            documentsLayoutBinding.health.gpsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentsScreen.setHealthInfo$lambda$0$0(DocumentsScreen.this, view);
                }
            });
            return;
        }
        DocumentsLayoutBinding documentsLayoutBinding2 = this.binding;
        documentsLayoutBinding2.health.notAvailableContainer.setVisibility(8);
        Picasso picasso = Picasso.get();
        String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        picasso.load(resourceUrl$default + healthInfo.getSkin_image_url()).error(this.emptyPhoto).into(documentsLayoutBinding2.health.photo);
        documentsLayoutBinding2.health.name.setText(healthInfo.getName());
        documentsLayoutBinding2.health.hpState.setText(healthInfo.getState());
        documentsLayoutBinding2.health.duration.setText(healthInfo.getMed_card_time());
        documentsLayoutBinding2.health.drugs.setText(healthInfo.getZavisimost());
        documentsLayoutBinding2.health.insurance.setText(healthInfo.getHealth_insurance());
        documentsLayoutBinding2.health.psych.setVisibility(8);
        documentsLayoutBinding2.health.psychLabel.setVisibility(8);
        documentsLayoutBinding2.health.psychDesc.setVisibility(8);
        Demorgan demorgan = healthInfo.getDemorgan();
        if (demorgan != null) {
            documentsLayoutBinding2.health.psych.setVisibility(0);
            documentsLayoutBinding2.health.psychLabel.setVisibility(0);
            documentsLayoutBinding2.health.psychDesc.setVisibility(8);
            documentsLayoutBinding2.health.psych.setText(demorgan.getCount());
            String sub_text = demorgan.getSub_text();
            if (sub_text != null) {
                documentsLayoutBinding2.health.psychDesc.setVisibility(0);
                documentsLayoutBinding2.health.psychDesc.setText(sub_text);
                try {
                    i = Color.parseColor(demorgan.getSub_text_color());
                } catch (Exception unused) {
                    i = -1;
                }
                documentsLayoutBinding2.health.psychDesc.setTextColor(i);
            }
        }
        int med_osmotr_progress = healthInfo.getMed_osmotr_progress();
        documentsLayoutBinding2.health.bar1.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar2.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar3.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar4.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar5.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar6.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar7.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar8.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar9.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        documentsLayoutBinding2.health.bar10.bar.setBackgroundResource(R.drawable.documents_bar_item_empty_bg);
        if (med_osmotr_progress >= 1) {
            documentsLayoutBinding2.health.bar1.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 2) {
            documentsLayoutBinding2.health.bar2.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 3) {
            documentsLayoutBinding2.health.bar3.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 4) {
            documentsLayoutBinding2.health.bar4.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 5) {
            documentsLayoutBinding2.health.bar5.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 6) {
            documentsLayoutBinding2.health.bar6.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 7) {
            documentsLayoutBinding2.health.bar7.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 8) {
            documentsLayoutBinding2.health.bar8.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 9) {
            documentsLayoutBinding2.health.bar9.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress >= 10) {
            documentsLayoutBinding2.health.bar10.bar.setBackgroundResource(R.drawable.documents_bar_item_bg);
        }
        if (med_osmotr_progress == 10) {
            documentsLayoutBinding2.health.medReviewCount.setVisibility(8);
            documentsLayoutBinding2.health.medReviewImage.setVisibility(0);
            documentsLayoutBinding2.health.medReviewText.setVisibility(0);
            documentsLayoutBinding2.health.desc.setText("Вы прошли необходимые 10 мед. осмотров у врачей и теперь можете не проходить\n обязательный мед. осмотр перед вылетом на работе пилота.");
            return;
        }
        documentsLayoutBinding2.health.medReviewCount.setVisibility(0);
        documentsLayoutBinding2.health.medReviewImage.setVisibility(8);
        documentsLayoutBinding2.health.medReviewText.setVisibility(8);
        documentsLayoutBinding2.health.medReviewCount.setText(med_osmotr_progress + " / 10");
        documentsLayoutBinding2.health.desc.setText("Пройдите 10 мед.осмотров у врачей 3+ ранга, чтобы больше\n не проходить его перед вылетом на работе пилота.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHealthInfo$lambda$0$0(DocumentsScreen documentsScreen, View view) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        SAMPUIElement.notifyClick$default(documentsScreen, 1, 2, null, 4, null);
    }

    private final void setArmyInfo(ArmyInfo armyInfo) {
        if (armyInfo.getNot() == 1) {
            this.binding.army.notAvailableContainer.setVisibility(0);
            return;
        }
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.army.notAvailableContainer.setVisibility(8);
        Picasso picasso = Picasso.get();
        String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        picasso.load(resourceUrl$default + armyInfo.getSkin_image_url()).error(this.emptyPhoto).into(documentsLayoutBinding.army.photo);
        documentsLayoutBinding.army.name.setText(armyInfo.getName());
        documentsLayoutBinding.army.armyOnline.setText(armyInfo.getArmy_online());
        documentsLayoutBinding.army.haveArmyTicket.setText(armyInfo.getHave_army_ticket());
        documentsLayoutBinding.army.rank.setText(armyInfo.getRank());
    }

    private final void clearPropertyInfo() {
        this.propertyResidentalAdapter.clearAllTasksList();
        this.propertyComercialAdapter.clearAllTasksList();
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.property.residentalRecycleView.setVisibility(8);
        documentsLayoutBinding.property.comercialRecycleView.setVisibility(8);
        documentsLayoutBinding.property.residentalEmpty.setVisibility(0);
        documentsLayoutBinding.property.comercialEmpty.setVisibility(0);
    }

    private final void setPropertyInfo(PropertyInfo propertyInfo) {
        if (propertyInfo.getNot() != 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : propertyInfo.getProperties()) {
                if (Intrinsics.areEqual(((PropertyItem) obj).getColumn(), "residential")) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : propertyInfo.getProperties()) {
                if (Intrinsics.areEqual(((PropertyItem) obj2).getColumn(), "commerce")) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            if (!arrayList2.isEmpty()) {
                this.propertyResidentalAdapter.addElements(arrayList2);
                DocumentsLayoutBinding documentsLayoutBinding = this.binding;
                documentsLayoutBinding.property.residentalEmpty.setVisibility(8);
                documentsLayoutBinding.property.residentalRecycleView.setVisibility(0);
            }
            if (arrayList4.isEmpty()) {
                return;
            }
            this.propertyComercialAdapter.addElements(arrayList4);
            DocumentsLayoutBinding documentsLayoutBinding2 = this.binding;
            documentsLayoutBinding2.property.comercialEmpty.setVisibility(8);
            documentsLayoutBinding2.property.comercialRecycleView.setVisibility(0);
        }
    }

    private final void clearVipInfo() {
        this.vipLevelAdapter.clearAllTasksList();
        this.vipTypeAdapter.clearAllTasksList();
    }

    private final void setVipInfo(VipInfo vipInfo) {
        int i;
        String str;
        if (vipInfo.getNot() != 1) {
            List<VipStatus> vip_statuses = vipInfo.getVip_statuses();
            if (vip_statuses != null && !vip_statuses.isEmpty()) {
                this.vipTypeAdapter.addElements(vipInfo.getVip_statuses());
                DocumentsLayoutBinding documentsLayoutBinding = this.binding;
                documentsLayoutBinding.vip.documentsButton1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DocumentsScreen.setVipInfo$lambda$0$0(DocumentsScreen.this, view);
                    }
                });
                documentsLayoutBinding.vip.documentsButton2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.documents.DocumentsScreen$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DocumentsScreen.setVipInfo$lambda$0$1(DocumentsScreen.this, view);
                    }
                });
                documentsLayoutBinding.vip.vipInfo.setVisibility(8);
                documentsLayoutBinding.vip.documentsVipStatusIc.setVisibility(8);
                documentsLayoutBinding.vip.documentsVipStatusGold.setVisibility(8);
                documentsLayoutBinding.vip.documentsVipEmpty.setVisibility(0);
                HeaderBlock header_block = vipInfo.getHeader_block();
                if (header_block != null) {
                    String add_vip_date = header_block.getAdd_vip_date();
                    if (add_vip_date != null) {
                        documentsLayoutBinding.vip.documentsVipStatusGold.setVisibility(0);
                        documentsLayoutBinding.vip.documentsVipStatysBottom.setText(add_vip_date);
                    }
                    if (header_block.getType_vip() != null) {
                        documentsLayoutBinding.vip.vipInfo.setVisibility(0);
                        documentsLayoutBinding.vip.documentsVipStatusIc.setVisibility(0);
                        documentsLayoutBinding.vip.documentsVipEmpty.setVisibility(8);
                        documentsLayoutBinding.vip.documentsVipDesc.setText(header_block.getVip_date());
                        if (Intrinsics.areEqual(header_block.getType_vip(), "diamond")) {
                            i = R.drawable.documents_vip_ic_diamondvip;
                        } else if (Intrinsics.areEqual(header_block.getType_vip(), "add")) {
                            i = R.drawable.documents_vip_ic_addvip;
                        } else if (Intrinsics.areEqual(header_block.getType_vip(), "premium")) {
                            i = R.drawable.documents_vip_ic_premvip;
                        } else {
                            i = Intrinsics.areEqual(header_block.getType_vip(), "titan") ? R.drawable.documents_vip_ic_titanvip : R.drawable.documents_vip_ic_addvip;
                        }
                        if (Intrinsics.areEqual(header_block.getType_vip(), "diamond")) {
                            str = "Diamond VIP";
                        } else if (Intrinsics.areEqual(header_block.getType_vip(), "add")) {
                            str = "ADD VIP";
                        } else if (Intrinsics.areEqual(header_block.getType_vip(), "premium")) {
                            str = "Premium VIP";
                        } else {
                            str = Intrinsics.areEqual(header_block.getType_vip(), "titan") ? "Titan Vip" : "VIP";
                        }
                        documentsLayoutBinding.vip.documentsVipLevel.setText(str);
                        documentsLayoutBinding.vip.documentsVipStatusIc.setImageResource(i);
                    }
                }
            }
            List<PremiumLevel> premium_levels = vipInfo.getPremium_levels();
            if (premium_levels == null || premium_levels.isEmpty()) {
                return;
            }
            this.vipLevelAdapter.addElements(vipInfo.getPremium_levels());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVipInfo$lambda$0$0(DocumentsScreen documentsScreen, View view) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        documentsScreen.notifyClick(1, 1, String.valueOf(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVipInfo$lambda$0$1(DocumentsScreen documentsScreen, View view) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        documentsScreen.notifyClick(2, 1, String.valueOf(view));
    }

    private final void clearTransportInfo() {
        this.transportAdapter.clearAllTasksList();
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.transport.transportRecycleView.setVisibility(8);
        documentsLayoutBinding.transport.transportEmpty.setVisibility(0);
    }

    private final void setTransportInfo(TransportInfo transportInfo) {
        List<TransportItem> vehicles;
        if (transportInfo.getNot() == 1 || (vehicles = transportInfo.getVehicles()) == null || vehicles.isEmpty()) {
            return;
        }
        this.transportAdapter.addElements(vehicles);
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.transport.transportRecycleView.setVisibility(0);
        documentsLayoutBinding.transport.transportEmpty.setVisibility(8);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DocumentScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/feature/documents/DocumentsScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "Licenses", "Health", "Army", "Property", "Transport", "Vip", "documents_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Main = new Navigation("Main", 0);
        public static final Navigation Licenses = new Navigation("Licenses", 1);
        public static final Navigation Health = new Navigation("Health", 2);
        public static final Navigation Army = new Navigation("Army", 3);
        public static final Navigation Property = new Navigation("Property", 4);
        public static final Navigation Transport = new Navigation("Transport", 5);
        public static final Navigation Vip = new Navigation("Vip", 6);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Main, Licenses, Health, Army, Property, Transport, Vip};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: DocumentScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/documents/DocumentsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "documents_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_DOCUMENTS);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DocumentsScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    private final void setLicensesItem(boolean z, boolean z2, ImageView imageView, TextView textView, TextView textView2, View view) {
        view.setVisibility(z2 ? 0 : 8);
        if (z) {
            imageView.setImageAlpha(255);
            textView.setTextColor(Color.parseColor("#2E5356"));
            textView2.setBackgroundResource(R.drawable.documents_licenses_text_bg);
            return;
        }
        imageView.setImageAlpha(51);
        textView.setTextColor(Color.parseColor("#2E535633"));
        textView2.setBackgroundResource(R.drawable.documents_licenses_text_bg_empty);
    }
}
