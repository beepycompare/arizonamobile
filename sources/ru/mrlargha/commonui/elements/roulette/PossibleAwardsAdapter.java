package ru.mrlargha.commonui.elements.roulette;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.CaseRouletteAwardItemBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: PossibleAwardsAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0006\u0010\u0014\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u001e\u0010\u0016\u001a\u00020\u00112\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\b\u0010\u0017\u001a\u00020\u000fH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/PossibleAwardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/roulette/PossibleAwardsAdapter$PossibleAwardsViewHolder;", "<init>", "()V", "caseAwards", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/roulette/CaseAward;", "Lkotlin/collections/ArrayList;", "sharedPreferences", "Landroid/content/SharedPreferences;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "clearAwards", "getAwardsList", "addAwards", "getItemCount", "PossibleAwardsViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PossibleAwardsAdapter extends RecyclerView.Adapter<PossibleAwardsViewHolder> {
    private final ArrayList<CaseAward> caseAwards = new ArrayList<>();
    private SharedPreferences sharedPreferences;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PossibleAwardsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SharedPreferences sharedPreferences = parent.getContext().getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.case_roulette_award_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new PossibleAwardsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PossibleAwardsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        CaseAward caseAward = this.caseAwards.get(i);
        Intrinsics.checkNotNullExpressionValue(caseAward, "get(...)");
        CaseAward caseAward2 = caseAward;
        CaseRouletteAwardItemBinding binding = holder.getBinding();
        int rarity = caseAward2.getRarity();
        if (rarity == 0) {
            binding.itemRarityStick.setCardBackgroundColor(Color.parseColor("#ABABAB"));
            binding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_0_glow);
        } else if (rarity == 1) {
            binding.itemRarityStick.setCardBackgroundColor(Color.parseColor("#6881FF"));
            binding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_1_glow);
        } else if (rarity == 2) {
            binding.itemRarityStick.setCardBackgroundColor(Color.parseColor("#E500FF"));
            binding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_2_glow);
        } else if (rarity == 3) {
            binding.itemRarityStick.setCardBackgroundColor(Color.parseColor("#FF3600"));
            binding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_3_glow);
        } else if (rarity == 4) {
            binding.itemRarityStick.setCardBackgroundColor(Color.parseColor("#FFBA00"));
            binding.itemRarityGlow.setImageResource(R.drawable.case_roulette_rarity_4_glow);
        }
        if (z) {
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "projects/arizona-rp/assets/images/donate/" + caseAward2.getUrl()).into(binding.itemIc);
            return;
        }
        Picasso picasso2 = Picasso.get();
        String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso2.load(resourceUrl2 + "projects/rodina-rp/systems/battlepass/items/" + caseAward2.getUrl()).into(binding.itemIc);
    }

    public final void clearAwards() {
        this.caseAwards.clear();
        notifyDataSetChanged();
    }

    public final ArrayList<CaseAward> getAwardsList() {
        return this.caseAwards;
    }

    public final void addAwards(ArrayList<CaseAward> caseAwards) {
        Intrinsics.checkNotNullParameter(caseAwards, "caseAwards");
        this.caseAwards.addAll(caseAwards);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.caseAwards.size();
    }

    /* compiled from: PossibleAwardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/roulette/PossibleAwardsAdapter$PossibleAwardsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/CaseRouletteAwardItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/CaseRouletteAwardItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PossibleAwardsViewHolder extends RecyclerView.ViewHolder {
        private final CaseRouletteAwardItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PossibleAwardsViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            CaseRouletteAwardItemBinding bind = CaseRouletteAwardItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final CaseRouletteAwardItemBinding getBinding() {
            return this.binding;
        }
    }
}
