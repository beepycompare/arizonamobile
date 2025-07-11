package ru.mrlargha.commonui.elements.animation.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.animation.domain.obj.AnimationCategory;
/* compiled from: AnimationCategoryAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019J\u0014\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationCategoryHolder;", "<init>", "()V", "context", "Landroid/content/Context;", "animationCategoryList", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/animation/domain/obj/AnimationCategory;", "Lkotlin/collections/ArrayList;", "onCategoryClickListener", "Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationCategoryAdapter$OnCategoryClickListener;", "setOnCategoryClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "getAnimationCategoryList", "", "addCategories", "data", "OnCategoryClickListener", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimationCategoryAdapter extends RecyclerView.Adapter<AnimationCategoryHolder> {
    private final ArrayList<AnimationCategory> animationCategoryList = new ArrayList<>();
    private Context context;
    private OnCategoryClickListener onCategoryClickListener;

    /* compiled from: AnimationCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationCategoryAdapter$OnCategoryClickListener;", "", "callback", "", "position", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnCategoryClickListener {
        void callback(int i);
    }

    public final void setOnCategoryClickListener(OnCategoryClickListener onCategoryClickListener) {
        Intrinsics.checkNotNullParameter(onCategoryClickListener, "onCategoryClickListener");
        this.onCategoryClickListener = onCategoryClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AnimationCategoryHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.context = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.animation_category_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new AnimationCategoryHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final AnimationCategoryHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getAnimationCategoryItemBinding().aciTittle.setText(this.animationCategoryList.get(i).getName());
        if (!this.animationCategoryList.get(i).isEnabled()) {
            LinearLayout linearLayout = holder.getAnimationCategoryItemBinding().aciBackground;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_category_button_disabled));
        }
        holder.getAnimationCategoryItemBinding().aciBackground.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.animation.presentation.adapter.AnimationCategoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimationCategoryAdapter.onBindViewHolder$lambda$2(AnimationCategoryAdapter.this, i, holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(AnimationCategoryAdapter animationCategoryAdapter, int i, AnimationCategoryHolder animationCategoryHolder, View view) {
        OnCategoryClickListener onCategoryClickListener;
        Object obj;
        Iterator<T> it = animationCategoryAdapter.animationCategoryList.iterator();
        while (true) {
            onCategoryClickListener = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((AnimationCategory) obj).isEnabled()) {
                break;
            }
        }
        AnimationCategory animationCategory = (AnimationCategory) obj;
        if (animationCategory != null) {
            animationCategory.setEnabled(false);
            animationCategoryAdapter.notifyItemChanged(animationCategoryAdapter.animationCategoryList.indexOf(animationCategory));
        }
        animationCategoryAdapter.animationCategoryList.get(i).setEnabled(true);
        LinearLayout linearLayout = animationCategoryHolder.getAnimationCategoryItemBinding().aciBackground;
        Context context = animationCategoryAdapter.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_category_button_enabled));
        OnCategoryClickListener onCategoryClickListener2 = animationCategoryAdapter.onCategoryClickListener;
        if (onCategoryClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onCategoryClickListener");
        } else {
            onCategoryClickListener = onCategoryClickListener2;
        }
        onCategoryClickListener.callback(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.animationCategoryList.size();
    }

    public final List<AnimationCategory> getAnimationCategoryList() {
        return CollectionsKt.toMutableList((Collection) this.animationCategoryList);
    }

    public final void addCategories(List<AnimationCategory> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        List mutableList = CollectionsKt.toMutableList((Collection) data);
        mutableList.add(new AnimationCategory(null, "Избранное", false));
        this.animationCategoryList.clear();
        this.animationCategoryList.addAll(mutableList);
        for (AnimationCategory animationCategory : data) {
            notifyItemInserted(data.indexOf(animationCategory));
        }
    }
}
