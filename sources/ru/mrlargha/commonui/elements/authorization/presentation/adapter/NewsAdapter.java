package ru.mrlargha.commonui.elements.authorization.presentation.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.AuthorizationNewsItemBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.api.obj.News;
/* compiled from: NewsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0014\u0010\u0014\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/adapter/NewsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/authorization/presentation/adapter/NewsViewHolder;", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "news", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/authorization/presentation/api/obj/News;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addNews", "", "getDateTime", "", CmcdData.STREAMING_FORMAT_SS, "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private final ArrayList<News> news;
    private final Activity targetActivity;

    public NewsAdapter(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.news = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.authorization_news_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new NewsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(NewsViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AuthorizationNewsItemBinding binding = holder.getBinding();
        Picasso.get().load(this.news.get(i).getImageUrl()).placeholder(R.drawable.banner_news).into(binding.authorizationNewsItemBanner);
        binding.authorizationNewsDate.setText(getDateTime(String.valueOf(this.news.get(i).getCreateDate())));
        binding.authorizationNewsDescription.setText(this.news.get(i).getTitle());
        binding.authorizationNewsItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.adapter.NewsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewsAdapter.onBindViewHolder$lambda$1$lambda$0(NewsAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(NewsAdapter newsAdapter, int i, View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(newsAdapter.news.get(i).getUrl()));
            if (newsAdapter.targetActivity.getPackageManager().resolveActivity(intent, 65536) != null) {
                newsAdapter.targetActivity.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.news.size();
    }

    public final void addNews(List<News> news) {
        Intrinsics.checkNotNullParameter(news, "news");
        this.news.clear();
        this.news.addAll(news);
        notifyDataSetChanged();
    }

    private final String getDateTime(String str) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").format(new Date(Long.parseLong(str) * 1000));
        } catch (Exception e) {
            return e.toString();
        }
    }
}
