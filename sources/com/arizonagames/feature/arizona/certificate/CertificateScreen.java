package com.arizonagames.feature.arizona.certificate;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import com.arizonagames.feature.arizona.certificate.databinding.CertificateInfoItemBinding;
import com.arizonagames.feature.arizona.certificate.databinding.CertificateInfoItemLeftBinding;
import com.arizonagames.feature.arizona.certificate.databinding.CertificateScreenBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.arizona.rating.CertificateApi;
import ru.mrlargha.certificate.ImagesKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.elements.items3d.ItemScene;
import ru.mrlargha.commonui.elements.items3d.ModelRotationTouchListener;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.UtilsKt;
import ru.mrlargha.ui.kit.ParseColoredTextKt;
/* compiled from: CertificateScreen.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u00018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\"H\u0016J\u0018\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020(H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0018H\u0002J\u0016\u00102\u001a\u00020(2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001aH\u0002J\u0016\u00103\u001a\u00020(2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001aH\u0002J\b\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020(H\u0002J\b\u00106\u001a\u00020(H\u0002J\b\u00107\u001a\u00020(H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/CertificateScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lcom/arizonagames/feature/arizona/certificate/databinding/CertificateScreenBinding;", "scene", "Lru/mrlargha/commonui/elements/items3d/ItemScene;", "getScene", "()Lru/mrlargha/commonui/elements/items3d/ItemScene;", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/arizona/rating/CertificateApi;", "mainInfo", "Lcom/arizonagames/feature/arizona/certificate/MainInfo;", "qualityTypeList", "", "Lcom/arizonagames/feature/arizona/certificate/QualityType;", "bonusType", "Lcom/arizonagames/feature/arizona/certificate/BonusType;", "zoomMultipler", "", "qualityType", "isCars", "", "bonuses", "Lcom/arizonagames/feature/arizona/certificate/ItemBonus;", "blockTimerJob", "Lkotlinx/coroutines/Job;", "setVisibility", "", "visible", "onBackendMessage", "data", "", "subId", "saveMainInfo", "item", "startAnimatedScreen", "setMainInfo", "saveBonuses", "setBonuses", "loadCars", "loadCarsBonus", "loadAccs", "loadAccsBonus", "Spawner", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CertificateScreen extends SAMPUIElement {
    private final CertificateApi api;
    private final CertificateScreenBinding binding;
    private Job blockTimerJob;
    private List<BonusType> bonusType;
    private List<ItemBonus> bonuses;
    private final ArizonaRetrofit client;
    private boolean isCars;
    private MainInfo mainInfo;
    private int qualityType;
    private List<QualityType> qualityTypeList;
    private final ItemScene scene;
    private final View screen;
    private float zoomMultipler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificateScreen(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.certificate_screen, (ViewGroup) null);
        this.screen = screen;
        CertificateScreenBinding bind = CertificateScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.scene = (ItemScene) targetActivity;
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (CertificateApi) ArizonaRetrofit.create$default(arizonaRetrofit, CertificateApi.class, false, null, new Function0() { // from class: com.arizonagames.feature.arizona.certificate.CertificateScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit api$lambda$0;
                api$lambda$0 = CertificateScreen.api$lambda$0(CertificateScreen.this, i);
                return api$lambda$0;
            }
        }, 6, null);
        this.qualityTypeList = CollectionsKt.emptyList();
        this.bonusType = CollectionsKt.emptyList();
        this.zoomMultipler = 1.0f;
        this.isCars = true;
        this.bonuses = CollectionsKt.emptyList();
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
    }

    public final ItemScene getScene() {
        return this.scene;
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit api$lambda$0(CertificateScreen certificateScreen, int i) {
        certificateScreen.getNotifier().setUIElementVisible(i, false);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        this.binding.overlay.setVisibility(8);
        this.binding.cardInfo.setVisibility(8);
        this.mainInfo = null;
        this.qualityTypeList = CollectionsKt.emptyList();
        this.bonusType = CollectionsKt.emptyList();
        this.binding.blackOverlay.setAlpha(1.0f);
        this.scene.closeScene();
        CertificateScreenBinding certificateScreenBinding = this.binding;
        certificateScreenBinding.topContainer.setTranslationY(-1000.0f);
        certificateScreenBinding.bottomContainer.setTranslationY(1000.0f);
        certificateScreenBinding.info1.getRoot().setTranslationX(-1000.0f);
        certificateScreenBinding.info2.getRoot().setTranslationX(-1000.0f);
        certificateScreenBinding.info3.getRoot().setTranslationX(1000.0f);
        certificateScreenBinding.info4.getRoot().setTranslationX(1000.0f);
        super.setVisibility(z);
    }

    private final void saveMainInfo(MainInfo mainInfo) {
        this.binding.blackOverlay.setAlpha(1.0f);
        this.mainInfo = mainInfo;
        int type = mainInfo.getType();
        if (type == 0) {
            loadCars();
            loadCarsBonus();
        } else if (type != 1) {
        } else {
            loadAccs();
            loadAccsBonus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimatedScreen() {
        CertificateScreen certificateScreen;
        Job launch$default;
        CertificateScreenBinding certificateScreenBinding = this.binding;
        certificateScreenBinding.topContainer.setTranslationY(-1000.0f);
        certificateScreenBinding.bottomContainer.setTranslationY(1000.0f);
        certificateScreenBinding.info1.getRoot().setTranslationX(-1000.0f);
        certificateScreenBinding.info2.getRoot().setTranslationX(-1000.0f);
        certificateScreenBinding.info3.getRoot().setTranslationX(1000.0f);
        certificateScreenBinding.info4.getRoot().setTranslationX(1000.0f);
        this.binding.blackOverlay.setAlpha(1.0f);
        MainInfo mainInfo = this.mainInfo;
        if (mainInfo != null) {
            setMainInfo(mainInfo);
            float zoom = mainInfo.getObjectViewer().getObjectModel().getZoom() * this.zoomMultipler * 1.8f;
            float f = zoom * 3;
            this.scene.scaleModel(mainInfo.getObjectViewer().getObjectModel().getId(), f);
            certificateScreen = this;
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getMain(), null, new CertificateScreen$startAnimatedScreen$2$1(f, zoom, (f - zoom) / 600, certificateScreen, mainInfo, null), 2, null);
            certificateScreen.blockTimerJob = launch$default;
        } else {
            certificateScreen = this;
        }
        certificateScreen.binding.blackOverlay.animate().alpha(0.0f).setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
        certificateScreen.binding.topContainer.animate().translationY(0.0f).setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
        certificateScreen.binding.bottomContainer.animate().translationY(0.0f).setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
        certificateScreen.binding.info1.getRoot().animate().translationX(0.0f).setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
        certificateScreen.binding.info2.getRoot().animate().translationX(0.0f).setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
        certificateScreen.binding.info3.getRoot().animate().translationX(0.0f).setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
        certificateScreen.binding.info4.getRoot().animate().translationX(0.0f).setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).start();
    }

    private final void setMainInfo(MainInfo mainInfo) {
        Object obj;
        try {
            int rarity = mainInfo.getRarity();
            String str = "certificate_bg1";
            if (rarity != 1) {
                if (rarity == 2) {
                    str = "certificate_bg2";
                } else if (rarity == 3) {
                    str = "certificate_bg3";
                }
            }
            String str2 = str;
            ConstraintLayout root = this.binding.getRoot();
            int id = mainInfo.getObjectViewer().getObjectModel().getId();
            ItemScene itemScene = this.scene;
            float zoom = mainInfo.getObjectViewer().getObjectModel().getZoom() * this.zoomMultipler;
            float x = mainInfo.getObjectViewer().getObjectModel().getRotation().getX();
            float y = mainInfo.getObjectViewer().getObjectModel().getRotation().getY();
            float z = mainInfo.getObjectViewer().getObjectModel().getRotation().getZ();
            String rotationAxis = mainInfo.getObjectViewer().getObjectModel().getRotationAxis();
            if (rotationAxis == null) {
                rotationAxis = "y";
            }
            root.setOnTouchListener(new ModelRotationTouchListener(id, 0.0f, 0.0f, itemScene, x, y, z, zoom, rotationAxis, 6, null));
            this.scene.setupScene();
            this.scene.setCarModel(mainInfo.getObjectViewer().getObjectModel().getId(), mainInfo.getObjectViewer().getObjectModel().getSimple_model(), str2, mainInfo.getObjectViewer().getObjectProperties().getMain_color(), mainInfo.getObjectViewer().getObjectProperties().getSec_color(), "hud", mainInfo.getObjectViewer().getObjectProperties().getWear(), this.isCars);
            List<ObjectComponent> objectComponents = mainInfo.getObjectViewer().getObjectComponents();
            if (objectComponents != null) {
                for (ObjectComponent objectComponent : objectComponents) {
                    this.scene.setCarModule(mainInfo.getObjectViewer().getObjectModel().getId(), objectComponent.getId(), objectComponent.getSimple_model());
                }
            }
            this.scene.rotateModel(mainInfo.getObjectViewer().getObjectModel().getId(), mainInfo.getObjectViewer().getObjectModel().getRotation().getX(), mainInfo.getObjectViewer().getObjectModel().getRotation().getY(), mainInfo.getObjectViewer().getObjectModel().getRotation().getZ());
            this.scene.scaleModel(mainInfo.getObjectViewer().getObjectModel().getId(), mainInfo.getObjectViewer().getObjectModel().getZoom() * 1.5f * this.zoomMultipler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CertificateScreenBinding certificateScreenBinding = this.binding;
        certificateScreenBinding.title.setText(mainInfo.getTitle());
        mainInfo.getPrice();
        if (mainInfo.getPrice() > 0) {
            certificateScreenBinding.sellText.setText(DonateUtilsKt.formatWithSpaces(mainInfo.getPrice()));
            certificateScreenBinding.sellIc.setVisibility(0);
        } else {
            certificateScreenBinding.sellText.setText("Перейти в рейтинг");
            certificateScreenBinding.sellIc.setVisibility(8);
        }
        certificateScreenBinding.bonusTitle.setText("Бонусы:");
        Iterator<T> it = this.qualityTypeList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((QualityType) obj).getId() == mainInfo.getRarityLevel()) {
                break;
            }
        }
        QualityType qualityType = (QualityType) obj;
        if (qualityType != null) {
            CustomCardView qualityBg = certificateScreenBinding.qualityBg;
            Intrinsics.checkNotNullExpressionValue(qualityBg, "qualityBg");
            String str3 = (String) CollectionsKt.getOrNull(qualityType.getColors(), 0);
            if (str3 != null) {
                int parseColor = Color.parseColor(str3);
                String str4 = (String) CollectionsKt.getOrNull(qualityType.getColors(), 1);
                if (str4 != null) {
                    CustomCardView.setBackground$default(qualityBg, parseColor, Color.parseColor(str4), null, null, 12, null);
                    TextView textView = certificateScreenBinding.qualityText;
                    String name = qualityType.getName();
                    textView.setText(name + " (" + mainInfo.getRarity() + ")");
                }
            }
        }
        Stat stat = (Stat) CollectionsKt.getOrNull(mainInfo.getStats(), 0);
        if (stat != null) {
            CertificateInfoItemBinding certificateInfoItemBinding = certificateScreenBinding.info1;
            certificateInfoItemBinding.ic.setImageResource(ImagesKt.certificateIc(stat.getIcon()));
            certificateInfoItemBinding.type.setText(stat.getTitle());
            certificateInfoItemBinding.value.setText(ParseColoredTextKt.toColoredText(stat.getValue(), -1));
        }
        Stat stat2 = (Stat) CollectionsKt.getOrNull(mainInfo.getStats(), 1);
        if (stat2 != null) {
            CertificateInfoItemBinding certificateInfoItemBinding2 = certificateScreenBinding.info2;
            certificateInfoItemBinding2.ic.setImageResource(ImagesKt.certificateIc(stat2.getIcon()));
            certificateInfoItemBinding2.type.setText(stat2.getTitle());
            certificateInfoItemBinding2.value.setText(ParseColoredTextKt.toColoredText(stat2.getValue(), -1));
        }
        Stat stat3 = (Stat) CollectionsKt.getOrNull(mainInfo.getStats(), 2);
        if (stat3 != null) {
            CertificateInfoItemLeftBinding certificateInfoItemLeftBinding = certificateScreenBinding.info3;
            certificateInfoItemLeftBinding.ic.setImageResource(ImagesKt.certificateIc(stat3.getIcon()));
            certificateInfoItemLeftBinding.type.setText(stat3.getTitle());
            certificateInfoItemLeftBinding.value.setText(ParseColoredTextKt.toColoredText(stat3.getValue(), -1));
        }
        Stat stat4 = (Stat) CollectionsKt.getOrNull(mainInfo.getStats(), 3);
        if (stat4 != null) {
            CertificateInfoItemLeftBinding certificateInfoItemLeftBinding2 = certificateScreenBinding.info4;
            certificateInfoItemLeftBinding2.ic.setImageResource(ImagesKt.certificateIc(stat4.getIcon()));
            certificateInfoItemLeftBinding2.type.setText(stat4.getTitle());
            certificateInfoItemLeftBinding2.value.setText(ParseColoredTextKt.toColoredText(stat4.getValue(), -1));
        }
        certificateScreenBinding.buttonGet.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.certificate.CertificateScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$1$6(CertificateScreen.this, view);
            }
        });
        certificateScreenBinding.buttonSell.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.certificate.CertificateScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$1$7(CertificateScreen.this, view);
            }
        });
        this.binding.qualityButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.certificate.CertificateScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$2(CertificateScreen.this, view);
            }
        });
        this.binding.overlay.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.certificate.CertificateScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$3(CertificateScreen.this, view);
            }
        });
        this.qualityType = mainInfo.getRarity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$1$6(CertificateScreen certificateScreen, View view) {
        SAMPUIElement.notifyClick$default(certificateScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$1$7(CertificateScreen certificateScreen, View view) {
        SAMPUIElement.notifyClick$default(certificateScreen, 1, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$2(CertificateScreen certificateScreen, View view) {
        certificateScreen.binding.cardInfo.setVisibility(0);
        certificateScreen.binding.overlay.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$3(CertificateScreen certificateScreen, View view) {
        certificateScreen.binding.overlay.setVisibility(8);
        certificateScreen.binding.cardInfo.setVisibility(8);
    }

    private final void saveBonuses(List<ItemBonus> list) {
        this.bonuses = list;
        setBonuses(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBonuses(List<ItemBonus> list) {
        Object obj;
        List<String> colors;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            ItemBonus itemBonus = (ItemBonus) it.next();
            Iterator<T> it2 = this.bonusType.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((BonusType) next).getId() == itemBonus.getId()) {
                    obj = next;
                    break;
                }
            }
            BonusType bonusType = (BonusType) obj;
            String str = (bonusType == null || (str = bonusType.getName()) == null) ? "" : "";
            String valueString = itemBonus.getValueString();
            if (valueString == null || valueString.length() == 0) {
                arrayList.add(str);
            } else {
                arrayList.add(str + " <span>" + itemBonus.getValueString() + "</span>");
            }
        }
        Iterator<T> it3 = this.qualityTypeList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (((QualityType) next2).getId() == this.qualityType) {
                obj = next2;
                break;
            }
        }
        QualityType qualityType = (QualityType) obj;
        this.binding.textBonus.setText(UtilsKt.buildSpannableList(CollectionsKt.toList(arrayList), -16777216, true, Integer.valueOf(Color.parseColor((qualityType == null || (colors = qualityType.getColors()) == null || (r8 = (String) CollectionsKt.getOrNull(colors, 0)) == null) ? "#9A9A9A" : "#9A9A9A")), true));
    }

    private final void loadCars() {
        this.isCars = true;
        this.zoomMultipler = 1.0f;
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new CertificateScreen$loadCars$1(this, null), 3, null);
    }

    private final void loadCarsBonus() {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new CertificateScreen$loadCarsBonus$1(this, null), 3, null);
    }

    private final void loadAccs() {
        this.isCars = false;
        this.zoomMultipler = 3.0f;
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new CertificateScreen$loadAccs$1(this, null), 3, null);
    }

    private final void loadAccsBonus() {
        this.zoomMultipler = 3.0f;
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new CertificateScreen$loadAccsBonus$1(this, null), 3, null);
    }

    /* compiled from: CertificateScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/CertificateScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.CERTIFICATE);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CertificateScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (i == 0) {
                if (MapperKt.isJsonValid(data)) {
                    saveMainInfo((MainInfo) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) MainInfo.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            } else if (i == 1) {
                if (MapperKt.isJsonValid(data)) {
                    Gson create = new GsonBuilder().setLenient().create();
                    JsonArray asJsonArray = ((JsonElement) create.fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                    Intrinsics.checkNotNull(asJsonArray);
                    JsonArray<JsonElement> jsonArray = asJsonArray;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                    for (JsonElement jsonElement : jsonArray) {
                        arrayList2.add(create.fromJson(jsonElement, (Class<Object>) ItemBonus.class));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = CollectionsKt.emptyList();
                }
                saveBonuses(arrayList);
            }
        } catch (Exception e) {
            Log.d("certificate", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity().getApplicationContext(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }
}
