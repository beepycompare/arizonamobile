package ru.mrlargha.commonui.elements.quest;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.RodinaQuestAwardsItemBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: QuestAwardsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAwardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/quest/QuestAwardsAdapter$QuestAwardsViewHolder;", "<init>", "()V", "questAwards", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/quest/QuestAwards;", "Lkotlin/collections/ArrayList;", "sharedPreferences", "Landroid/content/SharedPreferences;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "addQuestAwards", "", "QuestAwardsViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestAwardsAdapter extends RecyclerView.Adapter<QuestAwardsViewHolder> {
    private final ArrayList<QuestAwards> questAwards = new ArrayList<>();
    private SharedPreferences sharedPreferences;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public QuestAwardsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SharedPreferences sharedPreferences = parent.getContext().getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.rodina_quest_awards_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new QuestAwardsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.questAwards.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(QuestAwardsViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        RodinaQuestAwardsItemBinding binding = holder.getBinding();
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        QuestAwards questAwards = this.questAwards.get(i);
        Intrinsics.checkNotNullExpressionValue(questAwards, "get(...)");
        QuestAwards questAwards2 = questAwards;
        if (z) {
            binding.rodinaQuestInfoTitle.setText(questAwards2.getTitle());
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "projects/arizona-rp/assets/images/donate/" + questAwards2.getIcon()).placeholder(R.drawable.item_template).into(binding.rodinaQuestAwardsImage);
            return;
        }
        binding.rodinaQuestInfoTitle.setText(questAwards2.getTitle());
        Picasso picasso2 = Picasso.get();
        String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso2.load(resourceUrl2 + "projects/rodina-rp/assets/images/other/" + questAwards2.getIcon()).placeholder(R.drawable.item_template).into(binding.rodinaQuestAwardsImage);
    }

    public final void addQuestAwards(List<QuestAwards> questAwards) {
        Intrinsics.checkNotNullParameter(questAwards, "questAwards");
        this.questAwards.clear();
        this.questAwards.addAll(questAwards);
        int i = 0;
        for (Object obj : this.questAwards) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            QuestAwards questAwards2 = (QuestAwards) obj;
            notifyItemChanged(i);
            i = i2;
        }
    }

    /* compiled from: QuestAwardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAwardsAdapter$QuestAwardsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/RodinaQuestAwardsItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/RodinaQuestAwardsItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class QuestAwardsViewHolder extends RecyclerView.ViewHolder {
        private final RodinaQuestAwardsItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuestAwardsViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            RodinaQuestAwardsItemBinding bind = RodinaQuestAwardsItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final RodinaQuestAwardsItemBinding getBinding() {
            return this.binding;
        }
    }
}
