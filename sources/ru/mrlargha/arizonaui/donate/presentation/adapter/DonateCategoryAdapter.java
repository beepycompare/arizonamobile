package ru.mrlargha.arizonaui.donate.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.ArizonaDonateCategoryItemBinding;
import ru.mrlargha.arizonaui.donate.domain.obj.Category;
/* compiled from: DonateCategoryAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0014\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cJ\b\u0010\u001d\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateCategoryAdapter$DonateCategoryHolder;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateCategoryAdapter$CategoryOnClickListener;", "context", "Landroid/content/Context;", "defaultCategoryList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/donate/domain/obj/Category;", "Lkotlin/collections/ArrayList;", "getDefaultCategoryList", "()Ljava/util/ArrayList;", "categoryOnClick", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewRecycled", "addCategoryItem", "categoryList", "", "getItemCount", "CategoryOnClickListener", "DonateCategoryHolder", "Companion", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateCategoryAdapter extends RecyclerView.Adapter<DonateCategoryHolder> {
    public static final Companion Companion = new Companion(null);
    private Context context;
    private final ArrayList<Category> defaultCategoryList = new ArrayList<>();
    private CategoryOnClickListener listener;

    /* compiled from: DonateCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateCategoryAdapter$CategoryOnClickListener;", "", "categoryOnClick", "", "position", "", "view", "Landroid/view/View;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface CategoryOnClickListener {
        void categoryOnClick(int i, View view);
    }

    public final ArrayList<Category> getDefaultCategoryList() {
        return this.defaultCategoryList;
    }

    public final void categoryOnClick(CategoryOnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* compiled from: DonateCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateCategoryAdapter$DonateCategoryHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/ArizonaDonateCategoryItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/ArizonaDonateCategoryItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DonateCategoryHolder extends RecyclerView.ViewHolder {
        private final ArizonaDonateCategoryItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateCategoryHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            ArizonaDonateCategoryItemBinding bind = ArizonaDonateCategoryItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final ArizonaDonateCategoryItemBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonateCategoryHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.context = context;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.arizona_donate_category_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new DonateCategoryHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonateCategoryHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer img = this.defaultCategoryList.get(i).getImg();
        if (img != null) {
            int intValue = img.intValue();
            AppCompatImageView appCompatImageView = holder.getBinding().donateCategoryIcon;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context, intValue));
        }
        holder.getBinding().description.setText(this.defaultCategoryList.get(i).getTitle());
        String url = this.defaultCategoryList.get(i).getUrl();
        if (url != null) {
            Picasso.get().load(url).into(holder.getBinding().donateCategoryIcon);
        }
        if (this.defaultCategoryList.get(i).getOnClicked()) {
            holder.getBinding().donateCategoryIcon.setAlpha(1.0f);
            holder.getBinding().description.setAlpha(1.0f);
        }
        holder.getBinding().donateCategoryIcon.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.adapter.DonateCategoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateCategoryAdapter.onBindViewHolder$lambda$3(DonateCategoryAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(DonateCategoryAdapter donateCategoryAdapter, int i, View view) {
        CategoryOnClickListener categoryOnClickListener = donateCategoryAdapter.listener;
        if (categoryOnClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            categoryOnClickListener = null;
        }
        Intrinsics.checkNotNull(view);
        categoryOnClickListener.categoryOnClick(i, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(DonateCategoryHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().donateCategoryIcon.setAlpha(0.25f);
        holder.getBinding().description.setAlpha(0.25f);
    }

    public final void addCategoryItem(List<Category> categoryList) {
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        for (Category category : categoryList) {
            this.defaultCategoryList.add(category);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.defaultCategoryList.size();
    }

    /* compiled from: DonateCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateCategoryAdapter$Companion;", "", "<init>", "()V", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
