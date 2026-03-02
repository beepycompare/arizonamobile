package ru.mrlargha.arizona.promo;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
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
import kotlinx.datetime.internal.DateCalculationsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.promo.R;
import ru.mrlargha.feature.arizona.promo.databinding.PromoItemBinding;
/* compiled from: PromoAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u0006\u0010\u0019\u001a\u00020\u0006J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizona/promo/PromoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizona/promo/PromoItemViewHolder;", "onSelect", "Lkotlin/Function1;", "Lru/mrlargha/arizona/promo/PromoItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", "toText", "", "", NotificationCompat.CATEGORY_PROMO}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoAdapter extends RecyclerView.Adapter<PromoItemViewHolder> {
    private final List<PromoItem> itemsList;
    private final Function1<PromoItem, Unit> onSelect;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$2(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PromoAdapter(Function1<? super PromoItem, Unit> onSelect) {
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        this.onSelect = onSelect;
        this.itemsList = new ArrayList();
    }

    public final List<PromoItem> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PromoItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.promo_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new PromoItemViewHolder(inflate);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [ru.mrlargha.arizona.promo.PromoAdapter$onBindViewHolder$1$4] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PromoItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PromoItem promoItem = (PromoItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (promoItem == null) {
            promoItem = (PromoItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        final PromoItemBinding binding = holder.getBinding();
        binding.title.setText(promoItem.getTitle());
        holder.getRewardItemsAdapter().addAllItems(promoItem.getRewards());
        binding.buttonGet.setText(promoItem.getButtonName());
        String buttonStyle = promoItem.getButtonStyle();
        int hashCode = buttonStyle.hashCode();
        if (hashCode != -733902135) {
            if (hashCode != 270940796) {
                if (hashCode == 1544803905 && buttonStyle.equals("default")) {
                    binding.buttonCard.setBackground(-1);
                    CustomCardView buttonCard = binding.buttonCard;
                    Intrinsics.checkNotNullExpressionValue(buttonCard, "buttonCard");
                    CustomCardView.setBorder$default(buttonCard, Color.parseColor("#33FFFFFF"), Color.parseColor("#BCBCBC"), null, 4, null);
                    binding.buttonGet.setTextColor(-16777216);
                    binding.available.setVisibility(4);
                    binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.PromoAdapter$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PromoAdapter.onBindViewHolder$lambda$0$0(PromoAdapter.this, promoItem, view);
                        }
                    });
                }
            } else if (buttonStyle.equals("disabled")) {
                binding.buttonGet.setTextColor(Color.parseColor("#80FFFFFF"));
                binding.buttonCard.setBackground(Color.parseColor("#131516"));
                binding.buttonCard.setBorder(Color.parseColor("#33FFFFFF"));
                binding.available.setVisibility(4);
                binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.PromoAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PromoAdapter.onBindViewHolder$lambda$0$2(view);
                    }
                });
            }
        } else if (buttonStyle.equals("available")) {
            binding.buttonGet.setTextColor(-16777216);
            CustomCardView buttonCard2 = binding.buttonCard;
            Intrinsics.checkNotNullExpressionValue(buttonCard2, "buttonCard");
            CustomCardView.setBackground$default(buttonCard2, Color.parseColor("#FCD80F"), Color.parseColor("#FF9112"), null, null, 12, null);
            binding.available.setVisibility(0);
            binding.buttonCard.setBorder(Color.parseColor("#00FFFFFF"));
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.promo.PromoAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromoAdapter.onBindViewHolder$lambda$0$1(PromoAdapter.this, promoItem, view);
                }
            });
        }
        if (promoItem.getReceived() == 1) {
            binding.buttonGet.setVisibility(8);
            binding.buttonDone.setVisibility(0);
        } else {
            binding.buttonGet.setVisibility(0);
            binding.buttonDone.setVisibility(8);
        }
        binding.timerText.setText(promoItem.getBadge());
        binding.bottomText.setText(promoItem.getDescription());
        binding.timerText2.setText(toText(promoItem.getTimer()));
        binding.timerContainer.setVisibility(0);
        long timer = promoItem.getTimer();
        if (timer == -1) {
            binding.timerContainer.setVisibility(8);
        } else if (timer == 0) {
            binding.timerIc.setColorFilter(Color.parseColor("#82DB2A"));
            binding.timerText2.setTextColor(Color.parseColor("#82DB2A"));
        } else {
            binding.timerIc.setColorFilter(Color.parseColor("#FFBF00"));
            binding.timerText2.setTextColor(Color.parseColor("#FFBF00"));
        }
        CountDownTimer timer2 = holder.getTimer();
        if (timer2 != null) {
            timer2.cancel();
        }
        holder.setTimer(null);
        final long timer3 = promoItem.getTimer() * 1000;
        holder.setTimer(new CountDownTimer(timer3) { // from class: ru.mrlargha.arizona.promo.PromoAdapter$onBindViewHolder$1$4
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String text;
                TextView textView = PromoItemBinding.this.timerText2;
                text = this.toText(j / 1000);
                textView.setText(text);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                PromoItemBinding.this.timerIc.setColorFilter(Color.parseColor("#82DB2A"));
                PromoItemBinding.this.timerText2.setTextColor(Color.parseColor("#82DB2A"));
                cancel();
            }
        }.start());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(PromoAdapter promoAdapter, PromoItem promoItem, View view) {
        promoAdapter.onSelect.invoke(promoItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$1(PromoAdapter promoAdapter, PromoItem promoItem, View view) {
        promoAdapter.onSelect.invoke(promoItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<PromoItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PromoAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toText(long j) {
        if (j <= 0) {
            return "0";
        }
        long j2 = 86400;
        long j3 = j / j2;
        long j4 = (long) DateCalculationsKt.SECONDS_PER_HOUR;
        long j5 = (j % j2) / j4;
        long j6 = 60;
        long j7 = (j % j4) / j6;
        long j8 = j % j6;
        StringBuilder sb = new StringBuilder();
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            sb.append(j3 + " дн.");
        } else {
            int i2 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
            if (i2 > 0 || i > 0) {
                sb.append(" " + j5 + StringUtils.PROCESS_POSTFIX_DELIMITER + StringsKt.padStart(String.valueOf(j7), 2, '0'));
            } else if (j7 > 0) {
                sb.append(j7 + StringUtils.PROCESS_POSTFIX_DELIMITER + StringsKt.padStart(String.valueOf(j8), 2, '0'));
            } else {
                sb.append(String.valueOf(j8));
            }
            if (i2 > 0 && j8 != 0) {
                sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER + StringsKt.padStart(String.valueOf(j8), 2, '0'));
            }
        }
        return StringsKt.trim((CharSequence) sb.toString()).toString();
    }
}
