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
import kotlin.math.MathKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.RodinaQuestItemBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: QuestAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0014\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019J\u0006\u0010\u001a\u001a\u00020\u000eR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/quest/QuestAdapter$QuestViewHolder;", "<init>", "()V", "quests", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/quest/QuestLine;", "Lkotlin/collections/ArrayList;", "onQuestClickListener", "Lru/mrlargha/commonui/elements/quest/QuestAdapter$OnQuestClickListener;", "sharedPreferences", "Landroid/content/SharedPreferences;", "setOnQuestClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addQuests", "", "clearQuests", "OnQuestClickListener", "QuestViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestAdapter extends RecyclerView.Adapter<QuestViewHolder> {
    private OnQuestClickListener onQuestClickListener;
    private final ArrayList<QuestLine> quests = new ArrayList<>();
    private SharedPreferences sharedPreferences;

    /* compiled from: QuestAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAdapter$OnQuestClickListener;", "", "callback", "", "quest", "Lru/mrlargha/commonui/elements/quest/QuestLine;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnQuestClickListener {
        void callback(QuestLine questLine);
    }

    public final void setOnQuestClickListener(OnQuestClickListener onQuestClickListener) {
        Intrinsics.checkNotNullParameter(onQuestClickListener, "onQuestClickListener");
        this.onQuestClickListener = onQuestClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public QuestViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SharedPreferences sharedPreferences = parent.getContext().getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.rodina_quest_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new QuestViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(QuestViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        if (this.quests.isEmpty()) {
            return;
        }
        QuestLine questLine = this.quests.get(i);
        Intrinsics.checkNotNullExpressionValue(questLine, "get(...)");
        final QuestLine questLine2 = questLine;
        RodinaQuestItemBinding binding = holder.getBinding();
        binding.doneContainer.setVisibility(8);
        if (questLine2.getProgress() == questLine2.getMaxProgress()) {
            binding.rodinaQuestInfoStatTitle.setVisibility(8);
            binding.rodinaQuestProgress.setVisibility(8);
            binding.rodinaQuestInfoStatText.setVisibility(8);
            if (questLine2.getHasReward() == 0) {
                binding.getAwardContainer.setVisibility(0);
            } else {
                binding.doneContainer.setVisibility(0);
                binding.rodinaQuestItemBackground.setImageResource(R.drawable.rodina_quest_done_bg);
            }
        } else {
            binding.getAwardContainer.setVisibility(8);
            binding.rodinaQuestInfoStatTitle.setVisibility(0);
            binding.rodinaQuestProgress.setVisibility(0);
            binding.rodinaQuestInfoStatText.setVisibility(0);
            binding.rodinaQuestInfoStatText.setText(MathKt.roundToInt((questLine2.getProgress() / questLine2.getMaxProgress()) * 100) + "%");
            binding.rodinaQuestProgress.setMax(questLine2.getMaxProgress());
            binding.rodinaQuestProgress.setProgress(questLine2.getProgress());
        }
        if (z) {
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "projects/arizona-rp/systems/image_quest/" + questLine2.getImage()).placeholder(R.drawable.quest_template).into(binding.rodinaQuestItemImage);
        } else {
            Picasso picasso2 = Picasso.get();
            String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso2.load(resourceUrl2 + "projects/rodina-rp/systems/quest/" + questLine2.getImage()).placeholder(R.drawable.quest_template).into(binding.rodinaQuestItemImage);
        }
        binding.rodinaQuestInfoTitle.setText(questLine2.getTitle());
        binding.rodinaQuestItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestAdapter.onBindViewHolder$lambda$1$lambda$0(QuestAdapter.this, questLine2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(QuestAdapter questAdapter, QuestLine questLine, View view) {
        OnQuestClickListener onQuestClickListener = questAdapter.onQuestClickListener;
        if (onQuestClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onQuestClickListener");
            onQuestClickListener = null;
        }
        onQuestClickListener.callback(questLine);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.quests.size();
    }

    /* compiled from: QuestAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAdapter$QuestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/RodinaQuestItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/RodinaQuestItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class QuestViewHolder extends RecyclerView.ViewHolder {
        private final RodinaQuestItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuestViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            RodinaQuestItemBinding bind = RodinaQuestItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final RodinaQuestItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addQuests(List<QuestLine> quests) {
        Intrinsics.checkNotNullParameter(quests, "quests");
        ArrayList<QuestLine> arrayList = this.quests;
        arrayList.addAll(quests);
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            QuestLine questLine = (QuestLine) obj;
            notifyItemChanged(i);
            i = i2;
        }
    }

    public final void clearQuests() {
        this.quests.clear();
        notifyDataSetChanged();
    }
}
