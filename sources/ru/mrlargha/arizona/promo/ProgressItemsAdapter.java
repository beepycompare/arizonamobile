package ru.mrlargha.arizona.promo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.gradientBg.RadialBottomCenterCircleDrawable;
import ru.mrlargha.feature.arizona.promo.R;
import ru.mrlargha.feature.arizona.promo.databinding.ProgressItemBinding;
/* compiled from: ProgressItemsAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0014\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aJ\u0006\u0010\u001b\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizona/promo/ProgressItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizona/promo/ProgressItemViewHolder;", "onGetItem", "Lkotlin/Function1;", "Lru/mrlargha/arizona/promo/PromoReward;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnGetItem", "()Lkotlin/jvm/functions/Function1;", "itemsList", "", "doneColor", "", "undoneColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", NotificationCompat.CATEGORY_PROMO}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ProgressItemsAdapter extends RecyclerView.Adapter<ProgressItemViewHolder> {
    private final int doneColor;
    private final List<PromoReward> itemsList;
    private final Function1<PromoReward, Unit> onGetItem;
    private final int undoneColor;

    /* JADX WARN: Multi-variable type inference failed */
    public ProgressItemsAdapter(Function1<? super PromoReward, Unit> onGetItem) {
        Intrinsics.checkNotNullParameter(onGetItem, "onGetItem");
        this.onGetItem = onGetItem;
        this.itemsList = new ArrayList();
        this.doneColor = Color.parseColor("#FFBF00");
        this.undoneColor = Color.parseColor("#0D1011");
    }

    public final Function1<PromoReward, Unit> getOnGetItem() {
        return this.onGetItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ProgressItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ProgressItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ProgressItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PromoReward promoReward = (PromoReward) CollectionsKt.getOrNull(this.itemsList, i);
        if (promoReward == null) {
            promoReward = (PromoReward) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        ProgressItemBinding binding = holder.getBinding();
        binding.text.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, promoReward.getTitle(), 0.0f, null, 3, null));
        binding.text2.setText(promoReward.getRequirement());
        binding.colorBottom.setBackgroundColor(Color.parseColor(promoReward.getColor()));
        if (promoReward.getAvailable() == 1 || promoReward.getReceived() == 1) {
            binding.viewBeforeLevel.setBackgroundColor(this.doneColor);
            binding.viewAfterLevel.setBackgroundColor(this.doneColor);
            binding.levelContainer.setColorFilter(this.doneColor);
            binding.levelText.setTextColor(this.undoneColor);
        } else {
            binding.viewBeforeLevel.setBackgroundColor(this.undoneColor);
            binding.viewAfterLevel.setBackgroundColor(this.undoneColor);
            binding.levelContainer.setColorFilter(this.undoneColor);
            binding.levelText.setTextColor(-1);
        }
        binding.recieved.setVisibility(8);
        binding.buttonGet.setVisibility(8);
        if (promoReward.getReceived() == 1) {
            binding.recieved.setVisibility(0);
        } else if (promoReward.getAvailable() == 1) {
            binding.buttonGet.setVisibility(0);
            binding.buttonGet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.ProgressItemsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProgressItemsAdapter.onBindViewHolder$lambda$0$0(ProgressItemsAdapter.this, promoReward, view);
                }
            });
        }
        binding.levelText.setText(String.valueOf(i + 1));
        if (!UtilsKt.isArizonaType()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ProgressItemsAdapter$onBindViewHolder$1$2(promoReward, binding, null), 3, null);
        } else {
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(projectResourceUrl$default + "assets/images/donate/" + StringsKt.substringBeforeLast$default(promoReward.getImage(), ".", (String) null, 2, (Object) null) + ".webp").into(binding.image);
        }
        binding.image.setBackground(new RadialBottomCenterCircleDrawable(Color.parseColor(promoReward.getColor()), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(ProgressItemsAdapter progressItemsAdapter, PromoReward promoReward, View view) {
        progressItemsAdapter.onGetItem.invoke(promoReward);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<PromoReward> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ProgressItemsAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
