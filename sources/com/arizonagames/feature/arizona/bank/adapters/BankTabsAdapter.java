package com.arizonagames.feature.arizona.bank.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankContractKt;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.adapters.BankTabsAdapter;
import com.arizonagames.feature.arizona.bank.databinding.BankTabItemBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankTabsAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\u001d\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0014\u0010\u001e\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankTabsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/bank/adapters/BankTabsAdapter$BankTabViewHolder;", "pages", "", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "onClick", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "selectedPage", "enabledPages", "", "visiblePages", "displayedPages", "getDisplayedPages", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "setSelectedPage", "page", "setEnabledPages", "setVisiblePages", "BankTabViewHolder", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankTabsAdapter extends RecyclerView.Adapter<BankTabViewHolder> {
    private Set<? extends BankPage> enabledPages;
    private final Function1<BankPage, Unit> onClick;
    private final List<BankPage> pages;
    private BankPage selectedPage;
    private Set<? extends BankPage> visiblePages;

    /* JADX WARN: Multi-variable type inference failed */
    public BankTabsAdapter(List<? extends BankPage> pages, Function1<? super BankPage, Unit> onClick) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.pages = pages;
        this.onClick = onClick;
        this.enabledPages = CollectionsKt.toSet(pages);
        this.visiblePages = CollectionsKt.toSet(pages);
    }

    private final List<BankPage> getDisplayedPages() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.pages) {
            if (this.visiblePages.contains((BankPage) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BankTabViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BankTabItemBinding inflate = BankTabItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BankTabViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BankTabViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BankPage bankPage = getDisplayedPages().get(i);
        holder.bind(bankPage, bankPage == this.selectedPage, this.enabledPages.contains(bankPage), this.onClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getDisplayedPages().size();
    }

    public final void setSelectedPage(BankPage bankPage) {
        BankPage bankPage2 = this.selectedPage;
        if (bankPage2 == bankPage) {
            return;
        }
        int indexOf = bankPage2 != null ? getDisplayedPages().indexOf(bankPage2) : -1;
        this.selectedPage = bankPage;
        int indexOf2 = bankPage != null ? getDisplayedPages().indexOf(bankPage) : -1;
        if (indexOf != -1) {
            notifyItemChanged(indexOf);
        }
        if (indexOf2 != -1) {
            notifyItemChanged(indexOf2);
        }
    }

    public final void setEnabledPages(Set<? extends BankPage> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (Intrinsics.areEqual(this.enabledPages, pages)) {
            return;
        }
        this.enabledPages = pages;
        notifyDataSetChanged();
    }

    public final void setVisiblePages(Set<? extends BankPage> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (Intrinsics.areEqual(this.visiblePages, pages)) {
            return;
        }
        this.visiblePages = pages;
        notifyDataSetChanged();
    }

    /* compiled from: BankTabsAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankTabsAdapter$BankTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankTabItemBinding;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/databinding/BankTabItemBinding;)V", "bind", "", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "isSelected", "", "isEnabled", "onClick", "Lkotlin/Function1;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BankTabViewHolder extends RecyclerView.ViewHolder {
        private final BankTabItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankTabViewHolder(BankTabItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(final BankPage page, boolean z, boolean z2, final Function1<? super BankPage, Unit> onClick) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            TextView textView = this.binding.tabText;
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(BankContractKt.resolveTitle(page, context));
            int i = 8;
            this.binding.tabHotBadge.setVisibility(page == BankPage.LOTTERY ? 0 : 8);
            this.binding.tabCard.setBackgroundAlpha(z ? 100 : 0);
            this.binding.tabText.setTextColor(z ? Color.parseColor("#15182A") : -1);
            this.binding.tabHotBadge.setTextColor(z ? Color.parseColor("#15182A") : -1);
            float f = 0.65f;
            this.binding.tabText.setAlpha((z || z2) ? 1.0f : 0.65f);
            TextView textView2 = this.binding.tabHotBadge;
            if (z || z2) {
                f = 1.0f;
            }
            textView2.setAlpha(f);
            ImageView imageView = this.binding.tabLock;
            if (!z && !z2) {
                i = 0;
            }
            imageView.setVisibility(i);
            this.binding.getRoot().setEnabled(z2);
            this.binding.getRoot().setClickable(z2);
            FrameLayout root = this.binding.getRoot();
            final Function1 function1 = z2 ? new Function1() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankTabsAdapter$BankTabViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BankTabsAdapter.BankTabViewHolder.bind$lambda$0(Function1.this, page, (View) obj);
                }
            } : null;
            root.setOnClickListener(function1 != null ? new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankTabsAdapter$BankTabViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1.this.invoke(view);
                }
            } : null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit bind$lambda$0(Function1 function1, BankPage bankPage, View view) {
            function1.invoke(bankPage);
            return Unit.INSTANCE;
        }
    }
}
