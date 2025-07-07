package ru.mrlargha.arizonaui.bp_event_choice;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
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
import ru.mrlargha.arizonaui.databinding.DocumentsLayoutBinding;
import ru.mrlargha.arizonaui.documents.PropertyAdapter;
import ru.mrlargha.arizonaui.documents.TransportAdapter;
import ru.mrlargha.arizonaui.documents.VipLevelAdapter;
import ru.mrlargha.arizonaui.documents.VipTypeAdapter;
import ru.mrlargha.arizonaui.documents.data.DocumentsBites;
import ru.mrlargha.arizonaui.documents.data.InfoCommon;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: BpEventChoiceScreen.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002./B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050'2\u0006\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/arizonaui/bp_event_choice/BpEventChoiceScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/arizonaui/databinding/DocumentsLayoutBinding;", "isShowingDocs", "emptyPhoto", "propertyResidentalAdapter", "Lru/mrlargha/arizonaui/documents/PropertyAdapter;", "propertyComercialAdapter", "vipLevelAdapter", "Lru/mrlargha/arizonaui/documents/VipLevelAdapter;", "vipTypeAdapter", "Lru/mrlargha/arizonaui/documents/VipTypeAdapter;", "transportAdapter", "Lru/mrlargha/arizonaui/documents/TransportAdapter;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "soundIdNavigation", "soundIdOther", "onBackendMessage", "", "data", "", "subId", "setVisibility", "visible", "", "setTabsVisibility", "bites", "intToBitArrayMSB", "", "number", "setNavigation", "setAdapters", "navigateTo", "nav", "Lru/mrlargha/arizonaui/bp_event_choice/BpEventChoiceScreen$Navigation;", "Navigation", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BpEventChoiceScreen extends SAMPUIElement {
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

    /* compiled from: BpEventChoiceScreen.kt */
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
    public BpEventChoiceScreen(Activity targetActivity, int i) {
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
        this.vipLevelAdapter = new VipLevelAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vipLevelAdapter$lambda$0;
                vipLevelAdapter$lambda$0 = BpEventChoiceScreen.vipLevelAdapter$lambda$0(BpEventChoiceScreen.this, ((Integer) obj).intValue());
                return vipLevelAdapter$lambda$0;
            }
        });
        this.vipTypeAdapter = new VipTypeAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vipTypeAdapter$lambda$1;
                vipTypeAdapter$lambda$1 = BpEventChoiceScreen.vipTypeAdapter$lambda$1(BpEventChoiceScreen.this, ((Integer) obj).intValue());
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
    public static final Unit vipLevelAdapter$lambda$0(BpEventChoiceScreen bpEventChoiceScreen, int i) {
        bpEventChoiceScreen.soundPool.play(bpEventChoiceScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        bpEventChoiceScreen.notifyClick(3, 1, String.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vipTypeAdapter$lambda$1(BpEventChoiceScreen bpEventChoiceScreen, int i) {
        bpEventChoiceScreen.soundPool.play(bpEventChoiceScreen.soundIdOther, 1.0f, 1.0f, 0, 0, 1.0f);
        bpEventChoiceScreen.notifyClick(0, 1, String.valueOf(i));
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (i == 1) {
                Integer intOrNull2 = StringsKt.toIntOrNull(data);
                setTabsVisibility(intOrNull2 != null ? intOrNull2.intValue() : 0);
            } else if (i == 2) {
                int type = ((InfoCommon) MapperKt.toModel(data, InfoCommon.class)).getType();
                if (type == DocumentsBites.Main.getValue()) {
                    navigateTo(Navigation.Main);
                } else if (type == DocumentsBites.Licenses.getValue()) {
                    navigateTo(Navigation.Licenses);
                } else if (type == DocumentsBites.Health.getValue()) {
                    navigateTo(Navigation.Health);
                } else if (type == DocumentsBites.Army.getValue()) {
                    navigateTo(Navigation.Army);
                } else if (type == DocumentsBites.Property.getValue()) {
                    navigateTo(Navigation.Property);
                } else if (type == DocumentsBites.Transport.getValue()) {
                    navigateTo(Navigation.Transport);
                } else if (type == DocumentsBites.Vip.getValue()) {
                    navigateTo(Navigation.Vip);
                }
            } else if (i == 3) {
                InfoCommon infoCommon = (InfoCommon) MapperKt.toModel(data, InfoCommon.class);
            } else if (i == 4) {
                Integer intOrNull3 = StringsKt.toIntOrNull(data);
                this.isShowingDocs = intOrNull3 != null ? intOrNull3.intValue() : 0;
            } else if (i == 6 && (intOrNull = StringsKt.toIntOrNull(data)) != null) {
                int intValue = intOrNull.intValue();
                Log.d("frontend", "onBackendMessage: " + intValue);
                if (intValue == DocumentsBites.Main.getValue()) {
                    navigateTo(Navigation.Main);
                } else if (intValue == DocumentsBites.Licenses.getValue()) {
                    navigateTo(Navigation.Licenses);
                } else if (intValue == DocumentsBites.Health.getValue()) {
                    navigateTo(Navigation.Health);
                } else if (intValue == DocumentsBites.Army.getValue()) {
                    navigateTo(Navigation.Army);
                } else if (intValue == DocumentsBites.Property.getValue()) {
                    navigateTo(Navigation.Property);
                } else if (intValue == DocumentsBites.Transport.getValue()) {
                    navigateTo(Navigation.Transport);
                } else if (intValue == DocumentsBites.Vip.getValue()) {
                    navigateTo(Navigation.Vip);
                }
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
        documentsLayoutBinding.btnVip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setTabsVisibility$lambda$5$lambda$3(view);
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
            documentsLayoutBinding.btnVip.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BpEventChoiceScreen.setTabsVisibility$lambda$5$lambda$4(BpEventChoiceScreen.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTabsVisibility$lambda$5$lambda$4(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, DocumentsBites.Vip.getValue(), 3, null, 4, null);
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
        documentsLayoutBinding.documents.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$7(view);
            }
        });
        documentsLayoutBinding.btnMain.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$8(BpEventChoiceScreen.this, view);
            }
        });
        documentsLayoutBinding.btnLicenses.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$9(BpEventChoiceScreen.this, view);
            }
        });
        documentsLayoutBinding.btnHealth.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$10(BpEventChoiceScreen.this, view);
            }
        });
        documentsLayoutBinding.btnArmy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$11(BpEventChoiceScreen.this, view);
            }
        });
        documentsLayoutBinding.btnProperty.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$12(BpEventChoiceScreen.this, view);
            }
        });
        documentsLayoutBinding.btnTransport.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$13(BpEventChoiceScreen.this, view);
            }
        });
        documentsLayoutBinding.btnEsc.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.bp_event_choice.BpEventChoiceScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setNavigation$lambda$15$lambda$14(BpEventChoiceScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$8(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, DocumentsBites.Main.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$9(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, DocumentsBites.Licenses.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$10(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, DocumentsBites.Health.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$11(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, DocumentsBites.Army.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$12(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, DocumentsBites.Property.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$13(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, DocumentsBites.Transport.getValue(), 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigation$lambda$15$lambda$14(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, 0, 0, null, 4, null);
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BpEventChoiceScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/arizonaui/bp_event_choice/BpEventChoiceScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "Licenses", "Health", "Army", "Property", "Transport", "Vip", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* compiled from: BpEventChoiceScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/bp_event_choice/BpEventChoiceScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new BpEventChoiceScreen(targetActivity, i);
        }
    }
}
