package ru.mrlargha.feature.starter_pack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.starter_pack.adapters.StarterPackAdapter;
import ru.mrlargha.feature.starter_pack.databinding.StarterPackBinding;
import ru.mrlargha.feature.starter_pack.models.StarterPackModel;
/* compiled from: StarterPackScreen.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0016\u0010\u0019\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0006H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lru/mrlargha/feature/starter_pack/StarterPackScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/starter_pack/databinding/StarterPackBinding;", "newbieAdapter", "Lru/mrlargha/feature/starter_pack/adapters/StarterPackAdapter;", "richAdapter", "setVisible", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "setData", "list", "", "Lru/mrlargha/feature/starter_pack/models/StarterPackModel;", "setupNavigation", "setNewbie", CommonUrlParts.MODEL, "setRich", "initialize", "initArizona", "initRodina", "setupAdapters", "clearAdapters", "formatDuration", "seconds", "Spawner", "starter-pack"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StarterPackScreen extends SAMPUIElement implements InterfaceController {
    private final StarterPackBinding binding;
    private final StarterPackAdapter newbieAdapter;
    private final StarterPackAdapter richAdapter;
    private final View screen;

    private final void clearAdapters() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarterPackScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.starter_pack, (ViewGroup) null);
        this.screen = screen;
        StarterPackBinding bind = StarterPackBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.newbieAdapter = new StarterPackAdapter();
        this.richAdapter = new StarterPackAdapter();
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        initialize();
        setupAdapters();
        setupNavigation();
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        clearAdapters();
        this.binding.getRoot().setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 1) {
            setData(MapperKt.toListModel(data, StarterPackModel.class));
        }
    }

    private final void setData(List<StarterPackModel> list) {
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            StarterPackModel starterPackModel = (StarterPackModel) obj;
            int id = starterPackModel.getId();
            if (id == 0) {
                setNewbie(starterPackModel);
            } else if (id == 1) {
                setRich(starterPackModel);
            }
            i = i2;
        }
    }

    private final void setupNavigation() {
        StarterPackBinding starterPackBinding = this.binding;
        starterPackBinding.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.starter_pack.StarterPackScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StarterPackScreen.setupNavigation$lambda$0$0(StarterPackScreen.this, view);
            }
        });
        starterPackBinding.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.starter_pack.StarterPackScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StarterPackScreen.setupNavigation$lambda$0$1(StarterPackScreen.this, view);
            }
        });
        starterPackBinding.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.starter_pack.StarterPackScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StarterPackScreen.setupNavigation$lambda$0$2(StarterPackScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$0(StarterPackScreen starterPackScreen, View view) {
        SAMPUIElement.notifyClick$default(starterPackScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1(StarterPackScreen starterPackScreen, View view) {
        SAMPUIElement.notifyClick$default(starterPackScreen, 1, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2(StarterPackScreen starterPackScreen, View view) {
        SAMPUIElement.notifyClick$default(starterPackScreen, 1, 1, null, 4, null);
    }

    private final void setNewbie(StarterPackModel starterPackModel) {
        this.newbieAdapter.submitList(starterPackModel.getRewards());
        StarterPackBinding starterPackBinding = this.binding;
        starterPackBinding.tvNewbieTitle.setText(getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_title, new Object[]{starterPackModel.getTitle()}));
        starterPackBinding.newbieLevel.setText(getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_available_until_level, new Object[]{Integer.valueOf(starterPackModel.getLevel())}));
        starterPackBinding.price1.setText(getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_price_rubles, new Object[]{Integer.valueOf(starterPackModel.getPrice())}));
        String str = "systems/starter_packs/background/" + starterPackModel.getImage() + ".webp";
        String str2 = "systems/starter-packs/images/" + starterPackModel.getImage() + ".webp";
        Picasso picasso = Picasso.get();
        String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        if (!UtilsKt.isArizonaType()) {
            str = str2;
        }
        picasso.load(projectResourceUrl$default + str).into(starterPackBinding.bg1);
    }

    private final void setRich(StarterPackModel starterPackModel) {
        this.richAdapter.submitList(starterPackModel.getRewards());
        StarterPackBinding starterPackBinding = this.binding;
        starterPackBinding.tvRich2.setText(StringsKt.substringBefore$default(StringsKt.substringAfter$default(starterPackModel.getTitle(), ">", (String) null, 2, (Object) null), "<", (String) null, 2, (Object) null));
        starterPackBinding.richLevel.setText(getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_available_until_level, new Object[]{Integer.valueOf(starterPackModel.getLevel())}));
        starterPackBinding.price2.setText(getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_price_rubles, new Object[]{Integer.valueOf(starterPackModel.getPrice())}));
        String str = "systems/starter_packs/background/" + starterPackModel.getImage() + ".webp";
        String str2 = "systems/starter-packs/images/" + starterPackModel.getImage() + ".webp";
        Picasso picasso = Picasso.get();
        String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        if (!UtilsKt.isArizonaType()) {
            str = str2;
        }
        picasso.load(projectResourceUrl$default + str).into(starterPackBinding.bg2);
        if (starterPackModel.getOldPrice() > 0) {
            starterPackBinding.price2Old.setVisibility(0);
        } else {
            starterPackBinding.price2Old.setVisibility(8);
        }
        starterPackBinding.price2Old.setText(String.valueOf(starterPackModel.getOldPrice()));
        starterPackBinding.price2Old.setPaintFlags(16);
        if (starterPackModel.getDiscount() > 0) {
            starterPackBinding.discountContainer.setVisibility(0);
            starterPackBinding.discount.setText(getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_benefit, new Object[]{Integer.valueOf(starterPackModel.getDiscount())}));
        } else {
            starterPackBinding.discountContainer.setVisibility(8);
        }
        if (starterPackModel.getTime() > 0) {
            starterPackBinding.timeContainer.setVisibility(0);
            starterPackBinding.time.setText(formatDuration(starterPackModel.getTime()));
            return;
        }
        starterPackBinding.timeContainer.setVisibility(8);
    }

    private final void initialize() {
        if (UtilsKt.isArizonaType()) {
            initArizona();
        } else {
            initRodina();
        }
    }

    private final void initArizona() {
        StarterPackBinding starterPackBinding = this.binding;
        starterPackBinding.getRoot().setBackgroundResource(R.drawable.starter_pack_bg_arizona);
        starterPackBinding.ivSecondContainerBg.setImageResource(R.drawable.starter_pack_bg_gradient1_arizona);
        starterPackBinding.button2.setBackgroundResource(R.drawable.starter_pack_gradient_button2_arizona);
    }

    private final void initRodina() {
        StarterPackBinding starterPackBinding = this.binding;
        starterPackBinding.getRoot().setBackgroundResource(R.drawable.starter_pack_bg);
        starterPackBinding.ivSecondContainerBg.setImageResource(R.drawable.starter_pack_bg_gradient1);
        starterPackBinding.button2.setBackgroundResource(R.drawable.starter_pack_gradient_button2);
    }

    private final void setupAdapters() {
        StarterPackBinding starterPackBinding = this.binding;
        starterPackBinding.rvNewbie.setAdapter(this.newbieAdapter);
        starterPackBinding.rvRich.setAdapter(this.richAdapter);
    }

    private final String formatDuration(int i) {
        int i2 = i / 86400;
        int i3 = (i % 86400) / 3600;
        int i4 = (i % 3600) / 60;
        ArrayList arrayList = new ArrayList();
        if (i2 > 0) {
            String string = getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_duration_day, new Object[]{Integer.valueOf(i2)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(string);
        }
        if (i3 > 0 || i2 > 0) {
            String string2 = getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_duration_hour, new Object[]{Integer.valueOf(i3)});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            arrayList.add(string2);
        }
        String string3 = getTargetActivity().getString(ru.mrlargha.commonui.R.string.starter_pack_duration_minute, new Object[]{Integer.valueOf(i4)});
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(string3);
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    /* compiled from: StarterPackScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/starter_pack/StarterPackScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "starter-pack"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.STARTER_PACK_RODINA);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new StarterPackScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
