package ru.mrlargha.transport;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.certificate.MainInfo;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.elements.items3d.ItemScene;
import ru.mrlargha.commonui.elements.items3d.ModelRotationTouchListener;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.UtilsKt;
import ru.mrlargha.feature.certificate.R;
import ru.mrlargha.feature.certificate.databinding.CertificateInfoItemBinding;
import ru.mrlargha.feature.certificate.databinding.CertificateInfoItemLeftBinding;
import ru.mrlargha.feature.certificate.databinding.CertificateScreenBinding;
/* compiled from: CertificateScreen.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0016\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001fH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/transport/CertificateScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/certificate/databinding/CertificateScreenBinding;", "scene", "Lru/mrlargha/commonui/elements/items3d/ItemScene;", "getScene", "()Lru/mrlargha/commonui/elements/items3d/ItemScene;", "bonuses", "", "", "setVisible", "", "visible", "", "onBackendMessage", "data", "subId", "setBonus", "info", "setMainInfo", "Lru/mrlargha/certificate/MainInfo;", "Spawner", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CertificateScreen extends SAMPUIElement implements InterfaceController {
    private final CertificateScreenBinding binding;
    private List<String> bonuses;
    private final ItemScene scene;
    private final View screen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificateScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.certificate_screen, (ViewGroup) null);
        this.screen = screen;
        CertificateScreenBinding bind = CertificateScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.scene = (ItemScene) targetActivity;
        this.bonuses = CollectionsKt.emptyList();
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
    }

    public final ItemScene getScene() {
        return this.scene;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.getRoot().setVisibility(8);
        this.binding.overlay.setVisibility(8);
        this.binding.cardInfo.setVisibility(8);
        if (z) {
            return;
        }
        this.scene.closeScene();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                setBonus(MapperKt.toListModel(data, String.class));
            } else if (MapperKt.isJsonValid(data)) {
                setMainInfo((MainInfo) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) MainInfo.class));
            } else {
                throw new JsonParseException("Json is not valid");
            }
        } catch (Exception e) {
            Log.d("certificate", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity().getApplicationContext(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    private final void setBonus(List<String> list) {
        this.bonuses = list;
    }

    private final void setMainInfo(final MainInfo mainInfo) {
        try {
            int rarity = mainInfo.getRarity();
            String str = "certificate_bg1";
            if (rarity != 1) {
                if (rarity == 2) {
                    str = "certificate_bg2";
                } else if (rarity == 4) {
                    str = "certificate_bg3";
                }
            }
            Log.d("setCarModel", "id: " + mainInfo.getVehicleId() + " ");
            this.scene.setupScene();
            this.scene.setCarModel(mainInfo.getVehicleId(), str);
            this.binding.getRoot().setOnTouchListener(new ModelRotationTouchListener(mainInfo.getVehicleId(), 0.0f, 0.0f, this.scene, 6, null));
            List<Integer> vehicleComponents = mainInfo.getVehicleComponents();
            if (vehicleComponents != null) {
                for (Number number : vehicleComponents) {
                    int intValue = number.intValue();
                    Log.d("setCarModel", "id: " + intValue + " ");
                    this.scene.setCarModule(mainInfo.getVehicleId(), intValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        CertificateScreenBinding certificateScreenBinding = this.binding;
        certificateScreenBinding.title.setText(mainInfo.getCarName());
        if (mainInfo.getPriceButton() != null && mainInfo.getPriceButton().intValue() > 0) {
            certificateScreenBinding.buttonSell.setVisibility(0);
            certificateScreenBinding.sellText.setText(DonateUtilsKt.formatWithSpaces(mainInfo.getPriceButton().intValue()));
        } else {
            certificateScreenBinding.buttonSell.setVisibility(8);
        }
        certificateScreenBinding.bonusTitle.setText("Бонусы:");
        int rarity2 = mainInfo.getRarity();
        if (rarity2 == 1) {
            certificateScreenBinding.qualityText.setText("Хлам (" + mainInfo.getRarityLevel() + ")");
            CustomCardView qualityBg = certificateScreenBinding.qualityBg;
            Intrinsics.checkNotNullExpressionValue(qualityBg, "qualityBg");
            CustomCardView.setBackground$default(qualityBg, Color.parseColor("#E5E5E5"), Color.parseColor("#00787878"), null, null, 12, null);
            certificateScreenBinding.qualityText.setTextColor(Color.parseColor("#000000"));
            certificateScreenBinding.bonusTitle.setText("Недостатки:");
        } else if (rarity2 == 2) {
            certificateScreenBinding.qualityText.setText("Обычное (" + mainInfo.getRarityLevel() + ")");
            CustomCardView qualityBg2 = certificateScreenBinding.qualityBg;
            Intrinsics.checkNotNullExpressionValue(qualityBg2, "qualityBg");
            CustomCardView.setBackground$default(qualityBg2, Color.parseColor("#00FFFF"), Color.parseColor("#00003636"), null, null, 12, null);
            certificateScreenBinding.qualityText.setTextColor(Color.parseColor("#004D4D"));
        } else if (rarity2 == 4) {
            CustomCardView qualityBg3 = certificateScreenBinding.qualityBg;
            Intrinsics.checkNotNullExpressionValue(qualityBg3, "qualityBg");
            CustomCardView.setBackground$default(qualityBg3, Color.parseColor("#FFCC00"), Color.parseColor("#00FFCC00"), null, null, 12, null);
            certificateScreenBinding.qualityText.setText("Идеальное (" + mainInfo.getRarityLevel() + ")");
            certificateScreenBinding.qualityText.setTextColor(Color.parseColor("#672400"));
        }
        CertificateInfoItemBinding certificateInfoItemBinding = certificateScreenBinding.info1;
        certificateInfoItemBinding.ic.setImageResource(R.drawable.sertificate_ic_speed);
        certificateInfoItemBinding.type.setText("Скорость");
        certificateInfoItemBinding.value.setText(((int) mainInfo.getMaxSpeed()) + " км/ч");
        if (mainInfo.getMaxSpeedBonus() != null && mainInfo.getMaxSpeedBonus().floatValue() > 0.0f) {
            certificateInfoItemBinding.valueBonus.setVisibility(0);
            certificateInfoItemBinding.valueBonus.setText(" (+" + mainInfo.getMaxSpeedBonus() + "км/ч)");
        } else {
            certificateInfoItemBinding.valueBonus.setVisibility(8);
        }
        CertificateInfoItemBinding certificateInfoItemBinding2 = certificateScreenBinding.info2;
        certificateInfoItemBinding2.ic.setImageResource(R.drawable.sertificate_ic_engine);
        certificateInfoItemBinding2.type.setText("Мощность");
        certificateInfoItemBinding2.value.setText(String.valueOf(mainInfo.getPower()));
        if (mainInfo.getPowerBonus() != null && mainInfo.getPowerBonus().intValue() > 0) {
            certificateInfoItemBinding2.valueBonus.setVisibility(0);
            certificateInfoItemBinding2.valueBonus.setText(" (+" + mainInfo.getPowerBonus() + "%)");
        } else {
            certificateInfoItemBinding2.valueBonus.setVisibility(8);
        }
        CertificateInfoItemLeftBinding certificateInfoItemLeftBinding = certificateScreenBinding.info3;
        certificateInfoItemLeftBinding.ic.setImageResource(R.drawable.sertificate_ic_hp);
        certificateInfoItemLeftBinding.type.setText("Очков здоровья");
        certificateInfoItemLeftBinding.value.setText(String.valueOf(mainInfo.getHp()));
        if (mainInfo.getHpBonus() != null && mainInfo.getHpBonus().floatValue() > 0.0f) {
            certificateInfoItemLeftBinding.valueBonus.setVisibility(0);
            certificateInfoItemLeftBinding.valueBonus.setText(" (+" + mainInfo.getHpBonus() + "%)");
        } else {
            certificateInfoItemLeftBinding.valueBonus.setVisibility(8);
        }
        CertificateInfoItemLeftBinding certificateInfoItemLeftBinding2 = certificateScreenBinding.info4;
        certificateInfoItemLeftBinding2.ic.setImageResource(R.drawable.sertificate_ic_gov);
        certificateInfoItemLeftBinding2.type.setText("Гос. цена");
        certificateInfoItemLeftBinding2.valueBonus.setVisibility(8);
        certificateInfoItemLeftBinding2.value.setText(DonateUtilsKt.formatWithSpaces(mainInfo.getPrice()));
        if (mainInfo.getSupportsColor() != null && mainInfo.getSupportsColor().length() > 0) {
            certificateInfoItemLeftBinding2.type.setText("Цвет суппортов");
            certificateInfoItemLeftBinding2.value.setText(String.valueOf(mainInfo.getSupportsColor()));
        }
        certificateScreenBinding.buttonGet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.CertificateScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$1$4(CertificateScreen.this, view);
            }
        });
        certificateScreenBinding.buttonSell.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.CertificateScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$1$5(CertificateScreen.this, view);
            }
        });
        this.binding.qualityButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.CertificateScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$2(CertificateScreen.this, mainInfo, view);
            }
        });
        this.binding.overlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.CertificateScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateScreen.setMainInfo$lambda$3(CertificateScreen.this, view);
            }
        });
        this.binding.getRoot().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$1$4(CertificateScreen certificateScreen, View view) {
        certificateScreen.scene.closeScene();
        SAMPUIElement.notifyClick$default(certificateScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$1$5(CertificateScreen certificateScreen, View view) {
        certificateScreen.scene.closeScene();
        SAMPUIElement.notifyClick$default(certificateScreen, 1, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$2(CertificateScreen certificateScreen, MainInfo mainInfo, View view) {
        certificateScreen.binding.cardInfo.setVisibility(0);
        certificateScreen.binding.overlay.setVisibility(0);
        int rarity = mainInfo.getRarity();
        String str = "#9A9A9A";
        if (rarity != 1) {
            if (rarity == 2) {
                str = "#00FFFF";
            } else if (rarity == 4) {
                str = "#FFCC00";
            }
        }
        certificateScreen.binding.textBonus.setText(UtilsKt.buildSpannableList(certificateScreen.bonuses, Color.parseColor("#223144"), true, Integer.valueOf(Color.parseColor(str)), true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMainInfo$lambda$3(CertificateScreen certificateScreen, View view) {
        certificateScreen.binding.overlay.setVisibility(8);
        certificateScreen.binding.cardInfo.setVisibility(8);
    }

    /* compiled from: CertificateScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/transport/CertificateScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "certificate_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
}
