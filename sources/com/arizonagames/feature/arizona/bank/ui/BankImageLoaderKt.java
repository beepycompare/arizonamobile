package com.arizonagames.feature.arizona.bank.ui;

import android.widget.ImageView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: BankImageLoader.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006:\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\f"}, d2 = {"loadBankImage", "", "Landroid/widget/ImageView;", "path", "", "fallbackRes", "", "Landroidx/annotation/DrawableRes;", "hideWhenUnavailable", "", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;Z)V", "resolveBankImageUrl", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankImageLoaderKt {
    public static /* synthetic */ void loadBankImage$default(ImageView imageView, String str, Integer num, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        loadBankImage(imageView, str, num, z);
    }

    public static final void loadBankImage(final ImageView imageView, String path, Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Picasso picasso = Picasso.get();
        picasso.cancelRequest(imageView);
        if (num == null) {
            imageView.setImageDrawable(null);
        } else {
            imageView.setImageResource(num.intValue());
        }
        String resolveBankImageUrl = resolveBankImageUrl(path);
        if (resolveBankImageUrl == null) {
            imageView.setVisibility(z ? 4 : 0);
            return;
        }
        imageView.setVisibility(0);
        RequestCreator load = picasso.load(resolveBankImageUrl);
        if (num != null) {
            Intrinsics.checkNotNull(load);
            load.error(num.intValue());
        }
        if (z && num == null) {
            load.into(imageView, new Callback() { // from class: com.arizonagames.feature.arizona.bank.ui.BankImageLoaderKt$loadBankImage$2
                @Override // com.squareup.picasso.Callback
                public void onSuccess() {
                    imageView.setVisibility(0);
                }

                @Override // com.squareup.picasso.Callback
                public void onError(Exception exc) {
                    imageView.setImageDrawable(null);
                    imageView.setVisibility(4);
                }
            });
        } else {
            load.into(imageView);
        }
    }

    public static final String resolveBankImageUrl(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String obj = StringsKt.trim((CharSequence) path).toString();
        String str = obj;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "://", false, 2, (Object) null)) {
            return obj;
        }
        return FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + StringsKt.trimStart(obj, '/');
    }
}
