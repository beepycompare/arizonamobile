package ru.mrlargha.arizonaui.documents;

import android.app.Activity;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.DocumentLicensesBinding;
import ru.mrlargha.arizonaui.databinding.DocumentsArmyBinding;
import ru.mrlargha.arizonaui.databinding.DocumentsHealthBinding;
import ru.mrlargha.arizonaui.databinding.DocumentsLayoutBinding;
import ru.mrlargha.arizonaui.databinding.DocumentsMainBinding;
import ru.mrlargha.arizonaui.documents.data.ArmyInfo;
import ru.mrlargha.arizonaui.documents.data.Demorgan;
import ru.mrlargha.arizonaui.documents.data.DocumentsBites;
import ru.mrlargha.arizonaui.documents.data.HeaderBlock;
import ru.mrlargha.arizonaui.documents.data.HealthInfo;
import ru.mrlargha.arizonaui.documents.data.InfoCommon;
import ru.mrlargha.arizonaui.documents.data.InfoItemMain;
import ru.mrlargha.arizonaui.documents.data.LicenseInfo;
import ru.mrlargha.arizonaui.documents.data.LicenseItem;
import ru.mrlargha.arizonaui.documents.data.PremiumLevel;
import ru.mrlargha.arizonaui.documents.data.PropertyInfo;
import ru.mrlargha.arizonaui.documents.data.PropertyItem;
import ru.mrlargha.arizonaui.documents.data.TransportInfo;
import ru.mrlargha.arizonaui.documents.data.VipInfo;
import ru.mrlargha.arizonaui.documents.data.VipStatus;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DocumentScreen.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002KLB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050'2\u0006\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J(\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020#2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u001dH\u0002J\u0010\u0010F\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020\u001dH\u0002J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020JH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lru/mrlargha/arizonaui/documents/DocumentsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/arizonaui/databinding/DocumentsLayoutBinding;", "isShowingDocs", "emptyPhoto", "propertyResidentalAdapter", "Lru/mrlargha/arizonaui/documents/PropertyAdapter;", "propertyComercialAdapter", "vipLevelAdapter", "Lru/mrlargha/arizonaui/documents/VipLevelAdapter;", "vipTypeAdapter", "Lru/mrlargha/arizonaui/documents/VipTypeAdapter;", "transportAdapter", "Lru/mrlargha/arizonaui/documents/TransportAdapter;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "soundIdNavigation", "soundIdOther", "onBackendMessage", "", "data", "", "subId", "setVisibility", "visible", "", "setTabsVisibility", "bites", "intToBitArrayMSB", "", "number", "setNavigation", "setAdapters", "navigateTo", "nav", "Lru/mrlargha/arizonaui/documents/DocumentsScreen$Navigation;", "setMainInfo", "info", "Lru/mrlargha/arizonaui/documents/data/InfoItemMain;", "setLicensesInfo", "licenseInfo", "Lru/mrlargha/arizonaui/documents/data/LicenseInfo;", "setLicensesItem", "isRight", "document", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "item", "showDocs", "int", "dipLicense", "setHealthInfo", "Lru/mrlargha/arizonaui/documents/data/HealthInfo;", "setArmyInfo", "Lru/mrlargha/arizonaui/documents/data/ArmyInfo;", "clearPropertyInfo", "setPropertyInfo", "Lru/mrlargha/arizonaui/documents/data/PropertyInfo;", "clearVipInfo", "setVipInfo", "Lru/mrlargha/arizonaui/documents/data/VipInfo;", "clearTransportInfo", "setTransportInfo", "Lru/mrlargha/arizonaui/documents/data/TransportInfo;", "Navigation", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
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
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
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
    public static final void setNavigation$lambda$15$lambda$7(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTabsVisibility$lambda$5$lambda$3(View view) {
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
        this.vipLevelAdapter = new VipLevelAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vipLevelAdapter$lambda$0;
                vipLevelAdapter$lambda$0 = DocumentsScreen.vipLevelAdapter$lambda$0(DocumentsScreen.this, ((Integer) obj).intValue());
                return vipLevelAdapter$lambda$0;
            }
        });
        this.vipTypeAdapter = new VipTypeAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vipTypeAdapter$lambda$1;
                vipTypeAdapter$lambda$1 = DocumentsScreen.vipTypeAdapter$lambda$1(DocumentsScreen.this, ((Integer) obj).intValue());
                return vipTypeAdapter$lambda$1;
            }
        });
        this.transportAdapter = new TransportAdapter(targetActivity.getResources().getDimension(R.dimen._6sdp), targetActivity.getResources().getDimension(R.dimen._10sdp));
        SoundPool build = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setContentType(4).setUsage(14).build()).build();
        this.soundPool = build;
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setAdapters();
        setNavigation();
        Activity activity = targetActivity;
        this.soundIdNavigation = build.load(activity, R.raw.documents_nav_buttons, 1);
        this.soundIdOther = build.load(activity, R.raw.documents_other_buttons, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vipLevelAdapter$lambda$0(DocumentsScreen documentsScreen, int i) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        documentsScreen.notifyClick(3, 1, String.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vipTypeAdapter$lambda$1(DocumentsScreen documentsScreen, int i) {
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
            Toast.makeText(getTargetActivity(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
            getNotifier().setUIElementVisible(getBackendID(), false);
            SAMPUIElement.notifyClick$default(this, 0, 0, null, 4, null);
        }
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
        documentsLayoutBinding.btnVip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setTabsVisibility$lambda$5$lambda$3(view);
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
            documentsLayoutBinding.btnVip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentsScreen.setTabsVisibility$lambda$5$lambda$4(DocumentsScreen.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTabsVisibility$lambda$5$lambda$4(DocumentsScreen documentsScreen, View view) {
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
        documentsLayoutBinding.documents.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$7(view);
            }
        });
        documentsLayoutBinding.btnMain.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$8(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnLicenses.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$9(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnHealth.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$10(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnArmy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$11(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnProperty.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$12(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnTransport.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$13(DocumentsScreen.this, view);
            }
        });
        documentsLayoutBinding.btnEsc.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsScreen.setNavigation$lambda$15$lambda$14(DocumentsScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$8(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Main.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$9(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Licenses.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$10(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Health.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$11(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Army.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$12(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Property.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$13(DocumentsScreen documentsScreen, View view) {
        SAMPUIElement.notifyClick$default(documentsScreen, DocumentsBites.Transport.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$14(DocumentsScreen documentsScreen, View view) {
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
            documentsLayoutBinding.main.gpsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentsScreen.setMainInfo$lambda$18$lambda$17(DocumentsScreen.this, view);
                }
            });
            return;
        }
        DocumentsLayoutBinding documentsLayoutBinding2 = this.binding;
        documentsLayoutBinding2.main.notAvailableContainer.setVisibility(8);
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + infoItemMain.getSkin_image_url()).error(this.emptyPhoto).into(documentsLayoutBinding2.main.photo);
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
    public static final void setMainInfo$lambda$18$lambda$17(DocumentsScreen documentsScreen, View view) {
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
        List<LicenseItem> list;
        Object obj9;
        Object obj10;
        String str;
        Object obj11;
        String str2;
        Object obj12;
        String str3;
        String str4;
        Object obj13;
        Object obj14;
        String str5;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        Object obj22;
        Object obj23;
        Object obj24;
        Object obj25;
        Object obj26;
        Object obj27;
        Object obj28;
        Object obj29;
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
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        List<LicenseItem> info = licenseInfo.getInfo();
        TextView textView = documentsLayoutBinding.licenses.auto;
        List<LicenseItem> list2 = info;
        Iterator<T> it = list2.iterator();
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
        String str6 = "";
        textView.setText((licenseItem == null || (date_text14 = licenseItem.getDate_text()) == null) ? "" : date_text14);
        TextView textView2 = documentsLayoutBinding.licenses.moto;
        Iterator<T> it2 = list2.iterator();
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
        textView2.setText((licenseItem2 == null || (date_text13 = licenseItem2.getDate_text()) == null) ? "" : date_text13);
        TextView textView3 = documentsLayoutBinding.licenses.flight;
        Iterator<T> it3 = list2.iterator();
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
        textView3.setText((licenseItem3 == null || (date_text12 = licenseItem3.getDate_text()) == null) ? "" : date_text12);
        TextView textView4 = documentsLayoutBinding.licenses.boat;
        Iterator<T> it4 = list2.iterator();
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
        textView4.setText((licenseItem4 == null || (date_text11 = licenseItem4.getDate_text()) == null) ? "" : date_text11);
        TextView textView5 = documentsLayoutBinding.licenses.gun;
        Iterator<T> it5 = list2.iterator();
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
        textView5.setText((licenseItem5 == null || (date_text10 = licenseItem5.getDate_text()) == null) ? "" : date_text10);
        TextView textView6 = documentsLayoutBinding.licenses.fish;
        Iterator<T> it6 = list2.iterator();
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
        textView6.setText((licenseItem6 == null || (date_text9 = licenseItem6.getDate_text()) == null) ? "" : date_text9);
        TextView textView7 = documentsLayoutBinding.licenses.hunt;
        Iterator<T> it7 = list2.iterator();
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
        textView7.setText((licenseItem7 == null || (date_text8 = licenseItem7.getDate_text()) == null) ? "" : date_text8);
        TextView textView8 = documentsLayoutBinding.licenses.shave;
        Iterator<T> it8 = list2.iterator();
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
        textView8.setText((licenseItem8 == null || (date_text7 = licenseItem8.getDate_text()) == null) ? "" : date_text7);
        TextView textView9 = documentsLayoutBinding.licenses.taxi;
        Iterator<T> it9 = list2.iterator();
        while (true) {
            if (!it9.hasNext()) {
                list = list2;
                obj9 = null;
                break;
            }
            obj9 = it9.next();
            list = list2;
            if (Intrinsics.areEqual(((LicenseItem) obj9).getLicense(), "taxi")) {
                break;
            }
            list2 = list;
        }
        LicenseItem licenseItem9 = (LicenseItem) obj9;
        textView9.setText((licenseItem9 == null || (date_text6 = licenseItem9.getDate_text()) == null) ? "" : date_text6);
        TextView textView10 = documentsLayoutBinding.licenses.mech;
        Iterator it10 = list.iterator();
        while (true) {
            if (!it10.hasNext()) {
                obj10 = null;
                break;
            }
            obj10 = it10.next();
            Iterator it11 = it10;
            if (Intrinsics.areEqual(((LicenseItem) obj10).getLicense(), "mechanic")) {
                break;
            }
            it10 = it11;
        }
        LicenseItem licenseItem10 = (LicenseItem) obj10;
        textView10.setText((licenseItem10 == null || (date_text5 = licenseItem10.getDate_text()) == null) ? "" : date_text5);
        TextView textView11 = documentsLayoutBinding.licenses.advocate;
        Iterator it12 = list.iterator();
        while (true) {
            Iterator it13 = it12;
            if (!it12.hasNext()) {
                str = str6;
                obj11 = null;
                break;
            }
            obj11 = it13.next();
            str = str6;
            if (Intrinsics.areEqual(((LicenseItem) obj11).getLicense(), "lawyer")) {
                break;
            }
            it12 = it13;
            str6 = str;
        }
        LicenseItem licenseItem11 = (LicenseItem) obj11;
        textView11.setText((licenseItem11 == null || (date_text4 = licenseItem11.getDate_text()) == null) ? str : date_text4);
        TextView textView12 = documentsLayoutBinding.licenses.tax;
        Iterator it14 = list.iterator();
        while (true) {
            boolean hasNext = it14.hasNext();
            Iterator it15 = it14;
            str2 = "taxman";
            if (!hasNext) {
                obj12 = null;
                break;
            }
            Object next = it15.next();
            if (Intrinsics.areEqual(((LicenseItem) next).getLicense(), "taxman")) {
                obj12 = next;
                break;
            }
            it14 = it15;
        }
        LicenseItem licenseItem12 = (LicenseItem) obj12;
        textView12.setText((licenseItem12 == null || (date_text3 = licenseItem12.getDate_text()) == null) ? str : date_text3);
        TextView textView13 = documentsLayoutBinding.licenses.dipl;
        Iterator it16 = list.iterator();
        while (true) {
            boolean hasNext2 = it16.hasNext();
            Iterator it17 = it16;
            str3 = "diplomat";
            if (!hasNext2) {
                str4 = str2;
                obj13 = null;
                break;
            }
            obj13 = it17.next();
            str4 = str2;
            if (Intrinsics.areEqual(((LicenseItem) obj13).getLicense(), "diplomat")) {
                break;
            }
            it16 = it17;
            str2 = str4;
        }
        LicenseItem licenseItem13 = (LicenseItem) obj13;
        textView13.setText((licenseItem13 == null || (r4 = licenseItem13.getDate_text()) == null) ? "Отсутствует" : "Отсутствует");
        TextView textView14 = documentsLayoutBinding.licenses.diplTop;
        Iterator it18 = list.iterator();
        while (true) {
            if (!it18.hasNext()) {
                obj14 = null;
                break;
            }
            obj14 = it18.next();
            Iterator it19 = it18;
            if (Intrinsics.areEqual(((LicenseItem) obj14).getLicense(), "diplomat")) {
                break;
            }
            it18 = it19;
        }
        LicenseItem licenseItem14 = (LicenseItem) obj14;
        textView14.setText((licenseItem14 == null || (date_text2 = licenseItem14.getDate_text()) == null) ? str : date_text2);
        TextView textView15 = documentsLayoutBinding.licenses.miner;
        Iterator it20 = list.iterator();
        while (true) {
            Iterator it21 = it20;
            if (!it20.hasNext()) {
                str5 = str3;
                obj15 = null;
                break;
            }
            obj15 = it21.next();
            str5 = str3;
            if (Intrinsics.areEqual(((LicenseItem) obj15).getLicense(), "resource")) {
                break;
            }
            it20 = it21;
            str3 = str5;
        }
        LicenseItem licenseItem15 = (LicenseItem) obj15;
        textView15.setText((licenseItem15 == null || (date_text = licenseItem15.getDate_text()) == null) ? str : date_text);
        DocumentLicensesBinding documentLicensesBinding = documentsLayoutBinding.licenses;
        Iterator it22 = list.iterator();
        while (true) {
            if (!it22.hasNext()) {
                obj16 = null;
                break;
            }
            obj16 = it22.next();
            Iterator it23 = it22;
            if (Intrinsics.areEqual(((LicenseItem) obj16).getLicense(), "car")) {
                break;
            }
            it22 = it23;
        }
        LicenseItem licenseItem16 = (LicenseItem) obj16;
        boolean z = (licenseItem16 != null ? licenseItem16.getAvailable() : 0) == 1;
        ImageView documentsIcAuto = documentLicensesBinding.documentsIcAuto;
        Intrinsics.checkNotNullExpressionValue(documentsIcAuto, "documentsIcAuto");
        TextView autoTitle = documentLicensesBinding.autoTitle;
        Object obj30 = "resource";
        Intrinsics.checkNotNullExpressionValue(autoTitle, "autoTitle");
        TextView auto = documentLicensesBinding.auto;
        Object obj31 = "lawyer";
        Intrinsics.checkNotNullExpressionValue(auto, "auto");
        setLicensesItem(z, documentsIcAuto, autoTitle, auto);
        Iterator<T> it24 = list.iterator();
        while (true) {
            if (!it24.hasNext()) {
                obj17 = null;
                break;
            }
            obj17 = it24.next();
            if (Intrinsics.areEqual(((LicenseItem) obj17).getLicense(), "bike")) {
                break;
            }
        }
        LicenseItem licenseItem17 = (LicenseItem) obj17;
        boolean z2 = (licenseItem17 != null ? licenseItem17.getAvailable() : 0) == 1;
        ImageView documentsIcMoto = documentLicensesBinding.documentsIcMoto;
        Intrinsics.checkNotNullExpressionValue(documentsIcMoto, "documentsIcMoto");
        TextView motoTitle = documentLicensesBinding.motoTitle;
        Intrinsics.checkNotNullExpressionValue(motoTitle, "motoTitle");
        TextView moto = documentLicensesBinding.moto;
        Intrinsics.checkNotNullExpressionValue(moto, "moto");
        setLicensesItem(z2, documentsIcMoto, motoTitle, moto);
        Iterator<T> it25 = list.iterator();
        while (true) {
            if (!it25.hasNext()) {
                obj18 = null;
                break;
            }
            obj18 = it25.next();
            if (Intrinsics.areEqual(((LicenseItem) obj18).getLicense(), "fly")) {
                break;
            }
        }
        LicenseItem licenseItem18 = (LicenseItem) obj18;
        boolean z3 = (licenseItem18 != null ? licenseItem18.getAvailable() : 0) == 1;
        ImageView documentsIcFlight = documentLicensesBinding.documentsIcFlight;
        Intrinsics.checkNotNullExpressionValue(documentsIcFlight, "documentsIcFlight");
        TextView flightTitle = documentLicensesBinding.flightTitle;
        Intrinsics.checkNotNullExpressionValue(flightTitle, "flightTitle");
        TextView flight = documentLicensesBinding.flight;
        Intrinsics.checkNotNullExpressionValue(flight, "flight");
        setLicensesItem(z3, documentsIcFlight, flightTitle, flight);
        Iterator<T> it26 = list.iterator();
        while (true) {
            if (!it26.hasNext()) {
                obj19 = null;
                break;
            }
            obj19 = it26.next();
            if (Intrinsics.areEqual(((LicenseItem) obj19).getLicense(), "boat")) {
                break;
            }
        }
        LicenseItem licenseItem19 = (LicenseItem) obj19;
        boolean z4 = (licenseItem19 != null ? licenseItem19.getAvailable() : 0) == 1;
        ImageView documentsIcBoat = documentLicensesBinding.documentsIcBoat;
        Intrinsics.checkNotNullExpressionValue(documentsIcBoat, "documentsIcBoat");
        TextView boatTitle = documentLicensesBinding.boatTitle;
        Intrinsics.checkNotNullExpressionValue(boatTitle, "boatTitle");
        TextView boat = documentLicensesBinding.boat;
        Intrinsics.checkNotNullExpressionValue(boat, "boat");
        setLicensesItem(z4, documentsIcBoat, boatTitle, boat);
        Iterator<T> it27 = list.iterator();
        while (true) {
            if (!it27.hasNext()) {
                obj20 = null;
                break;
            }
            obj20 = it27.next();
            if (Intrinsics.areEqual(((LicenseItem) obj20).getLicense(), "gun")) {
                break;
            }
        }
        LicenseItem licenseItem20 = (LicenseItem) obj20;
        boolean z5 = (licenseItem20 != null ? licenseItem20.getAvailable() : 0) == 1;
        ImageView documentsIcGun = documentLicensesBinding.documentsIcGun;
        Intrinsics.checkNotNullExpressionValue(documentsIcGun, "documentsIcGun");
        TextView gunTitle = documentLicensesBinding.gunTitle;
        Intrinsics.checkNotNullExpressionValue(gunTitle, "gunTitle");
        TextView gun = documentLicensesBinding.gun;
        Intrinsics.checkNotNullExpressionValue(gun, "gun");
        setLicensesItem(z5, documentsIcGun, gunTitle, gun);
        Iterator<T> it28 = list.iterator();
        while (true) {
            if (!it28.hasNext()) {
                obj21 = null;
                break;
            }
            obj21 = it28.next();
            if (Intrinsics.areEqual(((LicenseItem) obj21).getLicense(), "fish")) {
                break;
            }
        }
        LicenseItem licenseItem21 = (LicenseItem) obj21;
        boolean z6 = (licenseItem21 != null ? licenseItem21.getAvailable() : 0) == 1;
        ImageView documentsIcFish = documentLicensesBinding.documentsIcFish;
        Intrinsics.checkNotNullExpressionValue(documentsIcFish, "documentsIcFish");
        TextView fishTitle = documentLicensesBinding.fishTitle;
        Intrinsics.checkNotNullExpressionValue(fishTitle, "fishTitle");
        TextView fish = documentLicensesBinding.fish;
        Intrinsics.checkNotNullExpressionValue(fish, "fish");
        setLicensesItem(z6, documentsIcFish, fishTitle, fish);
        Iterator<T> it29 = list.iterator();
        while (true) {
            if (!it29.hasNext()) {
                obj22 = null;
                break;
            }
            obj22 = it29.next();
            if (Intrinsics.areEqual(((LicenseItem) obj22).getLicense(), "hunter")) {
                break;
            }
        }
        LicenseItem licenseItem22 = (LicenseItem) obj22;
        boolean z7 = (licenseItem22 != null ? licenseItem22.getAvailable() : 0) == 1;
        ImageView documentsIcHunt = documentLicensesBinding.documentsIcHunt;
        Intrinsics.checkNotNullExpressionValue(documentsIcHunt, "documentsIcHunt");
        TextView huntTitle = documentLicensesBinding.huntTitle;
        Intrinsics.checkNotNullExpressionValue(huntTitle, "huntTitle");
        TextView hunt = documentLicensesBinding.hunt;
        Intrinsics.checkNotNullExpressionValue(hunt, "hunt");
        setLicensesItem(z7, documentsIcHunt, huntTitle, hunt);
        Iterator<T> it30 = list.iterator();
        while (true) {
            if (!it30.hasNext()) {
                obj23 = null;
                break;
            }
            obj23 = it30.next();
            if (Intrinsics.areEqual(((LicenseItem) obj23).getLicense(), "hitch")) {
                break;
            }
        }
        LicenseItem licenseItem23 = (LicenseItem) obj23;
        boolean z8 = (licenseItem23 != null ? licenseItem23.getAvailable() : 0) == 1;
        ImageView documentsIcShave = documentLicensesBinding.documentsIcShave;
        Intrinsics.checkNotNullExpressionValue(documentsIcShave, "documentsIcShave");
        TextView shaveTitle = documentLicensesBinding.shaveTitle;
        Intrinsics.checkNotNullExpressionValue(shaveTitle, "shaveTitle");
        TextView shave = documentLicensesBinding.shave;
        Intrinsics.checkNotNullExpressionValue(shave, "shave");
        setLicensesItem(z8, documentsIcShave, shaveTitle, shave);
        Iterator<T> it31 = list.iterator();
        while (true) {
            if (!it31.hasNext()) {
                obj24 = null;
                break;
            }
            obj24 = it31.next();
            if (Intrinsics.areEqual(((LicenseItem) obj24).getLicense(), "taxi")) {
                break;
            }
        }
        LicenseItem licenseItem24 = (LicenseItem) obj24;
        boolean z9 = (licenseItem24 != null ? licenseItem24.getAvailable() : 0) == 1;
        ImageView documentsIcTaxi = documentLicensesBinding.documentsIcTaxi;
        Intrinsics.checkNotNullExpressionValue(documentsIcTaxi, "documentsIcTaxi");
        TextView taxiTitle = documentLicensesBinding.taxiTitle;
        Intrinsics.checkNotNullExpressionValue(taxiTitle, "taxiTitle");
        TextView taxi = documentLicensesBinding.taxi;
        Intrinsics.checkNotNullExpressionValue(taxi, "taxi");
        setLicensesItem(z9, documentsIcTaxi, taxiTitle, taxi);
        Iterator<T> it32 = list.iterator();
        while (true) {
            if (!it32.hasNext()) {
                obj25 = null;
                break;
            }
            obj25 = it32.next();
            if (Intrinsics.areEqual(((LicenseItem) obj25).getLicense(), "mechanic")) {
                break;
            }
        }
        LicenseItem licenseItem25 = (LicenseItem) obj25;
        boolean z10 = (licenseItem25 != null ? licenseItem25.getAvailable() : 0) == 1;
        ImageView documentsIcMech = documentLicensesBinding.documentsIcMech;
        Intrinsics.checkNotNullExpressionValue(documentsIcMech, "documentsIcMech");
        TextView mechTitle = documentLicensesBinding.mechTitle;
        Intrinsics.checkNotNullExpressionValue(mechTitle, "mechTitle");
        TextView mech = documentLicensesBinding.mech;
        Intrinsics.checkNotNullExpressionValue(mech, "mech");
        setLicensesItem(z10, documentsIcMech, mechTitle, mech);
        Iterator<T> it33 = list.iterator();
        while (true) {
            if (!it33.hasNext()) {
                obj26 = null;
                break;
            }
            obj26 = it33.next();
            Object obj32 = obj31;
            if (Intrinsics.areEqual(((LicenseItem) obj26).getLicense(), obj32)) {
                break;
            }
            obj31 = obj32;
        }
        LicenseItem licenseItem26 = (LicenseItem) obj26;
        boolean z11 = (licenseItem26 != null ? licenseItem26.getAvailable() : 0) == 1;
        ImageView documentsIcAdvocate = documentLicensesBinding.documentsIcAdvocate;
        Intrinsics.checkNotNullExpressionValue(documentsIcAdvocate, "documentsIcAdvocate");
        TextView advocateTitle = documentLicensesBinding.advocateTitle;
        Intrinsics.checkNotNullExpressionValue(advocateTitle, "advocateTitle");
        TextView advocate = documentLicensesBinding.advocate;
        Intrinsics.checkNotNullExpressionValue(advocate, "advocate");
        setLicensesItem(z11, documentsIcAdvocate, advocateTitle, advocate);
        Iterator<T> it34 = list.iterator();
        while (true) {
            if (!it34.hasNext()) {
                obj27 = null;
                break;
            }
            obj27 = it34.next();
            String str7 = str4;
            if (Intrinsics.areEqual(((LicenseItem) obj27).getLicense(), str7)) {
                break;
            }
            str4 = str7;
        }
        LicenseItem licenseItem27 = (LicenseItem) obj27;
        boolean z12 = (licenseItem27 != null ? licenseItem27.getAvailable() : 0) == 1;
        ImageView documentsIcTax = documentLicensesBinding.documentsIcTax;
        Intrinsics.checkNotNullExpressionValue(documentsIcTax, "documentsIcTax");
        TextView taxTitle = documentLicensesBinding.taxTitle;
        Intrinsics.checkNotNullExpressionValue(taxTitle, "taxTitle");
        TextView tax = documentLicensesBinding.tax;
        Intrinsics.checkNotNullExpressionValue(tax, "tax");
        setLicensesItem(z12, documentsIcTax, taxTitle, tax);
        Iterator<T> it35 = list.iterator();
        while (true) {
            if (!it35.hasNext()) {
                obj28 = null;
                break;
            }
            obj28 = it35.next();
            String str8 = str5;
            if (Intrinsics.areEqual(((LicenseItem) obj28).getLicense(), str8)) {
                break;
            }
            str5 = str8;
        }
        LicenseItem licenseItem28 = (LicenseItem) obj28;
        boolean z13 = (licenseItem28 != null ? licenseItem28.getAvailable() : 0) == 1;
        ImageView documentsIcDipl = documentLicensesBinding.documentsIcDipl;
        Intrinsics.checkNotNullExpressionValue(documentsIcDipl, "documentsIcDipl");
        TextView diplTitle = documentLicensesBinding.diplTitle;
        Intrinsics.checkNotNullExpressionValue(diplTitle, "diplTitle");
        TextView dipl = documentLicensesBinding.dipl;
        Intrinsics.checkNotNullExpressionValue(dipl, "dipl");
        setLicensesItem(z13, documentsIcDipl, diplTitle, dipl);
        Iterator<T> it36 = list.iterator();
        while (true) {
            if (!it36.hasNext()) {
                obj29 = null;
                break;
            }
            Object next2 = it36.next();
            Object obj33 = obj30;
            if (Intrinsics.areEqual(((LicenseItem) next2).getLicense(), obj33)) {
                obj29 = next2;
                break;
            }
            obj30 = obj33;
        }
        LicenseItem licenseItem29 = (LicenseItem) obj29;
        boolean z14 = (licenseItem29 != null ? licenseItem29.getAvailable() : 0) == 1;
        ImageView documentsIcMiner = documentLicensesBinding.documentsIcMiner;
        Intrinsics.checkNotNullExpressionValue(documentsIcMiner, "documentsIcMiner");
        TextView minerTitle = documentLicensesBinding.minerTitle;
        Intrinsics.checkNotNullExpressionValue(minerTitle, "minerTitle");
        TextView miner = documentLicensesBinding.miner;
        Intrinsics.checkNotNullExpressionValue(miner, "miner");
        setLicensesItem(z14, documentsIcMiner, minerTitle, miner);
    }

    private final void setLicensesItem(boolean z, ImageView imageView, TextView textView, TextView textView2) {
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

    private final void showDocs(int i) {
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        if (i == 0) {
            DocumentsMainBinding documentsMainBinding = documentsLayoutBinding.main;
            documentsMainBinding.documentsMainDesc.setText("У вас нет пасспорта. Вы можете оформить его в Мэрии штата. Используйте кнопку снизу, чтобы отметить Мэрию на GPS.");
            documentsMainBinding.gpsButton.setVisibility(0);
            DocumentLicensesBinding documentLicensesBinding = documentsLayoutBinding.licenses;
            documentsLayoutBinding.licenses.containerDescription.setVisibility(0);
            DocumentsHealthBinding documentsHealthBinding = documentsLayoutBinding.health;
            documentsHealthBinding.reviewContainer.setVisibility(0);
            documentsHealthBinding.desc.setVisibility(0);
            documentsHealthBinding.gpsButton.setVisibility(0);
            documentsHealthBinding.descText.setText("У вас нет мед.карты. Вы можете оформить ее в любой больнице штата. Используйте кнопку ниже, чтобы отметить на GPS ближайшую больницу.");
            DocumentsArmyBinding documentsArmyBinding = documentsLayoutBinding.army;
            documentsArmyBinding.info.setVisibility(0);
            documentsArmyBinding.infoIc.setVisibility(0);
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
            documentsLayoutBinding.health.gpsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentsScreen.setHealthInfo$lambda$62$lambda$61(DocumentsScreen.this, view);
                }
            });
            return;
        }
        DocumentsLayoutBinding documentsLayoutBinding2 = this.binding;
        documentsLayoutBinding2.health.notAvailableContainer.setVisibility(8);
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + healthInfo.getSkin_image_url()).error(this.emptyPhoto).into(documentsLayoutBinding2.health.photo);
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
    public static final void setHealthInfo$lambda$62$lambda$61(DocumentsScreen documentsScreen, View view) {
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
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + armyInfo.getSkin_image_url()).error(this.emptyPhoto).into(documentsLayoutBinding.army.photo);
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
                documentsLayoutBinding.vip.documentsButton1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DocumentsScreen.setVipInfo$lambda$78$lambda$73(DocumentsScreen.this, view);
                    }
                });
                documentsLayoutBinding.vip.documentsButton2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.documents.DocumentsScreen$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DocumentsScreen.setVipInfo$lambda$78$lambda$74(DocumentsScreen.this, view);
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
    public static final void setVipInfo$lambda$78$lambda$73(DocumentsScreen documentsScreen, View view) {
        documentsScreen.soundPool.play(documentsScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        documentsScreen.notifyClick(1, 1, String.valueOf(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVipInfo$lambda$78$lambda$74(DocumentsScreen documentsScreen, View view) {
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
        if (transportInfo.getNot() == 1 || transportInfo.getVehicles().isEmpty()) {
            return;
        }
        this.transportAdapter.addElements(transportInfo.getVehicles());
        DocumentsLayoutBinding documentsLayoutBinding = this.binding;
        documentsLayoutBinding.transport.transportRecycleView.setVisibility(0);
        documentsLayoutBinding.transport.transportEmpty.setVisibility(8);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DocumentScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/arizonaui/documents/DocumentsScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "Licenses", "Health", "Army", "Property", "Transport", "Vip", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
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

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }
    }

    /* compiled from: DocumentScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/documents/DocumentsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DocumentsScreen(targetActivity, i);
        }
    }
}
