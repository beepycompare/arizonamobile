package ru.mrlargha.commonui.elements.roulette;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.CaseRouletteBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: CaseRouletteScreen.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0!H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \n*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/CaseRouletteScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "caseLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "caseBinding", "Lru/mrlargha/commonui/databinding/CaseRouletteBinding;", "possibleAwardsAdapter", "Lru/mrlargha/commonui/elements/roulette/PossibleAwardsAdapter;", "rouletteAwardsAdapter", "Lru/mrlargha/commonui/elements/roulette/RouletteAwardsAdapter;", "isNeedInstantOpen", "", "sharedPref", "Landroid/content/SharedPreferences;", "isArizonaType", "initRoulette", "", "response", "Lru/mrlargha/commonui/elements/roulette/RouletteResponse;", "moveToPrize", "prizePosition", "showPrize", "prizeItem", "Lru/mrlargha/commonui/elements/roulette/CaseAward;", "addExtraAwards", "awards", "", "setInstantOpen", "needOpen", "onBackendMessage", "data", "", "subId", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CaseRouletteScreen extends SAMPUIElement {
    private final CaseRouletteBinding caseBinding;
    private final View caseLayout;
    private final boolean isArizonaType;
    private boolean isNeedInstantOpen;
    private PossibleAwardsAdapter possibleAwardsAdapter;
    private final RouletteAwardsAdapter rouletteAwardsAdapter;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaseRouletteScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View caseLayout = targetActivity.getLayoutInflater().inflate(R.layout.case_roulette, (ViewGroup) null);
        this.caseLayout = caseLayout;
        final CaseRouletteBinding bind = CaseRouletteBinding.bind(caseLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.caseBinding = bind;
        this.possibleAwardsAdapter = new PossibleAwardsAdapter();
        RouletteAwardsAdapter rouletteAwardsAdapter = new RouletteAwardsAdapter();
        this.rouletteAwardsAdapter = rouletteAwardsAdapter;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        caseLayout.setClickable(true);
        Intrinsics.checkNotNullExpressionValue(caseLayout, "caseLayout");
        addViewToConstraintLayout(caseLayout, -1, -1);
        this.isNeedInstantOpen = false;
        bind.possibleAwardsRc.setAdapter(this.possibleAwardsAdapter);
        bind.caseRouletteRc.setAdapter(rouletteAwardsAdapter);
        bind.openCaseButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.roulette.CaseRouletteScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaseRouletteScreen.lambda$4$lambda$0(CaseRouletteScreen.this, bind, view);
            }
        });
        bind.getPrizeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.roulette.CaseRouletteScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaseRouletteScreen.lambda$4$lambda$1(CaseRouletteScreen.this, view);
            }
        });
        bind.exitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.roulette.CaseRouletteScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(CaseRouletteScreen.this, 0, 2, null, 4, null);
            }
        });
        bind.instantOpenContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.roulette.CaseRouletteScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(CaseRouletteScreen.this, 0, 3, null, 4, null);
            }
        });
        if (z) {
            return;
        }
        TextView tvInstantOpen = bind.tvInstantOpen;
        Intrinsics.checkNotNullExpressionValue(tvInstantOpen, "tvInstantOpen");
        tvInstantOpen.setVisibility(8);
        ConstraintLayout instantOpenContainer = bind.instantOpenContainer;
        Intrinsics.checkNotNullExpressionValue(instantOpenContainer, "instantOpenContainer");
        instantOpenContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$0(CaseRouletteScreen caseRouletteScreen, CaseRouletteBinding caseRouletteBinding, View view) {
        SAMPUIElement.notifyClick$default(caseRouletteScreen, 0, 0, null, 4, null);
        caseRouletteBinding.casePage.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$1(CaseRouletteScreen caseRouletteScreen, View view) {
        CaseRouletteScreen caseRouletteScreen2 = caseRouletteScreen;
        SAMPUIElement.notifyClick$default(caseRouletteScreen2, 0, 1, null, 4, null);
        SAMPUIElement.notifyClick$default(caseRouletteScreen2, 0, 2, null, 4, null);
    }

    private final void initRoulette(RouletteResponse rouletteResponse) {
        String str;
        CaseRouletteBinding caseRouletteBinding = this.caseBinding;
        caseRouletteBinding.caseRouletteStick.setVisibility(8);
        caseRouletteBinding.prizePage.setVisibility(8);
        caseRouletteBinding.casePage.setVisibility(0);
        caseRouletteBinding.caseName.setText(rouletteResponse.getName());
        if (this.isArizonaType) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/donate/";
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/battlepass/items/";
        }
        Picasso.get().load(str + rouletteResponse.getSysName() + ".webp").into(caseRouletteBinding.caseIc);
        this.possibleAwardsAdapter.clearAwards();
        this.rouletteAwardsAdapter.clearAwards();
    }

    private final void moveToPrize(int i) {
        final CaseRouletteBinding caseRouletteBinding = this.caseBinding;
        caseRouletteBinding.caseRouletteStick.setVisibility(0);
        caseRouletteBinding.casePage.setVisibility(8);
        ArrayList<CaseAward> awardsList = this.possibleAwardsAdapter.getAwardsList();
        caseRouletteBinding.caseRouletteRc.setLayoutManager(new CenterLayoutManager(getTargetActivity(), 0, false));
        ArrayList<CaseAward> arrayList = new ArrayList<>();
        final CaseAward caseAward = awardsList.size() > i ? awardsList.get(i) : awardsList.get(0);
        Intrinsics.checkNotNull(caseAward);
        if (this.isNeedInstantOpen) {
            showPrize(caseAward);
            return;
        }
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: ru.mrlargha.commonui.elements.roulette.CaseRouletteScreen$moveToPrize$1$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i2 == 0) {
                    CaseRouletteScreen.this.showPrize(caseAward);
                    recyclerView.removeOnScrollListener(this);
                }
            }
        };
        while (arrayList.size() < 150) {
            arrayList.addAll(awardsList);
        }
        Collections.shuffle(arrayList);
        arrayList.add(75, caseAward);
        this.rouletteAwardsAdapter.addAwards(arrayList);
        caseRouletteBinding.caseRouletteRc.addOnScrollListener(onScrollListener);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.roulette.CaseRouletteScreen$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                CaseRouletteScreen.moveToPrize$lambda$7$lambda$6(CaseRouletteBinding.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveToPrize$lambda$7$lambda$6(CaseRouletteBinding caseRouletteBinding) {
        caseRouletteBinding.caseRouletteRc.smoothScrollToPosition(75);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPrize(CaseAward caseAward) {
        CaseRouletteBinding caseRouletteBinding = this.caseBinding;
        caseRouletteBinding.prizePage.setVisibility(0);
        int rarity = caseAward.getRarity();
        if (rarity == 0) {
            caseRouletteBinding.prizeRarityStick.setCardBackgroundColor(Color.parseColor("#ABABAB"));
            caseRouletteBinding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_0_glow);
            caseRouletteBinding.secretPrizeText.setText("Обычный приз");
            caseRouletteBinding.secretPrizeText.setTextColor(Color.parseColor("#ABABAB"));
            caseRouletteBinding.prizeJoke.setText((CharSequence) CollectionsKt.listOf((Object[]) new String[]{"Это было близко!", "Еще разок?", "Удача была близко!"}).get(Random.Default.nextInt(0, 3)));
        } else if (rarity == 1) {
            caseRouletteBinding.prizeRarityStick.setCardBackgroundColor(Color.parseColor("#6881FF"));
            caseRouletteBinding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_1_glow);
            caseRouletteBinding.secretPrizeText.setText("Превосходный приз");
            caseRouletteBinding.secretPrizeText.setTextColor(Color.parseColor("#6881FF"));
            caseRouletteBinding.prizeJoke.setText((CharSequence) CollectionsKt.listOf((Object[]) new String[]{"Вот это да!", "ГОСПОДИ ЭТО ЖЕ!", "Вдох, выдох, приз!"}).get(Random.Default.nextInt(0, 3)));
        } else if (rarity == 2) {
            caseRouletteBinding.prizeRarityStick.setCardBackgroundColor(Color.parseColor("#E500FF"));
            caseRouletteBinding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_2_glow);
            caseRouletteBinding.secretPrizeText.setText("Секретный приз");
            caseRouletteBinding.secretPrizeText.setTextColor(Color.parseColor("#E500FF"));
            caseRouletteBinding.prizeJoke.setText((CharSequence) CollectionsKt.listOf((Object[]) new String[]{"Сектор приз!", "Интересненько...", "Оп-па"}).get(Random.Default.nextInt(0, 3)));
        } else if (rarity == 3) {
            caseRouletteBinding.prizeRarityStick.setCardBackgroundColor(Color.parseColor("#FF3600"));
            caseRouletteBinding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_3_glow);
            caseRouletteBinding.secretPrizeText.setText("Тайный приз");
            caseRouletteBinding.secretPrizeText.setTextColor(Color.parseColor("#FF3600"));
            caseRouletteBinding.prizeJoke.setText((CharSequence) CollectionsKt.listOf((Object[]) new String[]{"Минус се...", "ПОБЕДИТЕЛЬ!", "Великолепно!"}).get(Random.Default.nextInt(0, 3)));
        } else if (rarity == 4) {
            caseRouletteBinding.prizeRarityStick.setCardBackgroundColor(Color.parseColor("#FFBA00"));
            caseRouletteBinding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_4_glow);
            caseRouletteBinding.secretPrizeText.setText("Легендарный приз");
            caseRouletteBinding.secretPrizeText.setTextColor(Color.parseColor("#FFBA00"));
            caseRouletteBinding.prizeJoke.setText((CharSequence) CollectionsKt.listOf((Object[]) new String[]{"ААААААААА!!!", "Ограбление\nбанкомата", "Фортуна на вашей стороне!"}).get(Random.Default.nextInt(0, 3)));
        }
        caseRouletteBinding.prizeName.setText(caseAward.getName());
        Picasso.get().load((this.isArizonaType ? FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/donate/" : FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/battlepass/items/") + caseAward.getUrl()).into(caseRouletteBinding.prizeIc);
    }

    private final void addExtraAwards(List<CaseAward> list) {
        this.possibleAwardsAdapter.addAwards(new ArrayList<>(list));
    }

    private final void setInstantOpen(int i) {
        CaseRouletteBinding caseRouletteBinding = this.caseBinding;
        if (i == 0) {
            caseRouletteBinding.instantOpenContainerIc.setVisibility(8);
            this.isNeedInstantOpen = false;
            return;
        }
        caseRouletteBinding.instantOpenContainerIc.setVisibility(0);
        this.isNeedInstantOpen = true;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            initRoulette((RouletteResponse) MapperKt.toModel(data, RouletteResponse.class));
        } else if (i == 1) {
            moveToPrize(Integer.parseInt(data));
        } else if (i == 2) {
            addExtraAwards(MapperKt.toListModel(data, CaseAward.class));
        } else if (i != 3) {
        } else {
            setInstantOpen(Integer.parseInt(data));
        }
    }

    /* compiled from: CaseRouletteScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/CaseRouletteScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CaseRouletteScreen(targetActivity, i);
        }
    }
}
