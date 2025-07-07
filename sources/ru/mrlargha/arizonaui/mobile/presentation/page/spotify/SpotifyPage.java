package ru.mrlargha.arizonaui.mobile.presentation.page.spotify;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.databinding.MobilePhoneSpotifyPageBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.obj.ChangeArtistNameRadioRequest;
import ru.mrlargha.arizonaui.mobile.presentation.HistoryManager;
import ru.mrlargha.arizonaui.mobile.presentation.MobileController;
import ru.mrlargha.arizonaui.mobile.presentation.MobilePhone;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyGenreAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyTrackListAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.api.SpotifyApi;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.api.obj.SpotifyTrackResponse;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: SpotifyPage.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020&H\u0002J\u0014\u0010)\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0017J\u0014\u0010/\u001a\u00020&2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010+J\u000e\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u0017J\u0016\u00104\u001a\u00020&2\u0006\u00103\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0017J\u000e\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208J\b\u00109\u001a\u00020&H\u0016J\b\u0010:\u001a\u00020&H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyPage;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "<init>", "()V", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/api/SpotifyApi;", "kotlin.jvm.PlatformType", "mobilePhone", "Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "mobileContext", "Landroid/app/Activity;", "phoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "spotifyPage", "Landroidx/constraintlayout/widget/ConstraintLayout;", "spotifyPageBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneSpotifyPageBinding;", "stateMachine", "", "", "spotifyGenreAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyGenreAdapter;", "spotifyTrackListAdapter", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyTrackListAdapter;", "playingTrackId", "Ljava/lang/Integer;", "timer", "Landroid/os/CountDownTimer;", "currentCategoryId", "currentTrackProgressInSec", "getCategoryIdByName", "categoryName", "", "spotifyState", "", "stateId", "hideAllDynamicView", "initFavourite", "favouriteList", "", "addToFavourite", "favouriteId", "removeFromFavourite", "changeArtistNameRadio", "changeArtistNameRadioRequest", "Lru/mrlargha/arizonaui/mobile/domain/obj/ChangeArtistNameRadioRequest;", "playRadio", "trackId", "addPlayedTrack", "second", "playerInfoVisible", "isPlayerInfoVisible", "", "renderPage", "removePage", "SpotifyState", "Companion", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpotifyPage implements MobileController {
    private static boolean isTrackPlaying;
    private final SpotifyApi api;
    private int currentCategoryId;
    private int currentTrackProgressInSec;
    private final Activity mobileContext;
    private final MobilePhone mobilePhone;
    private final MobilePhoneBinding phoneBinding;
    private Integer playingTrackId;
    private Retrofit retrofit;
    private final IBackendNotifier sendFrontedMessage;
    private final SpotifyGenreAdapter spotifyGenreAdapter;
    private final ConstraintLayout spotifyPage;
    private final MobilePhoneSpotifyPageBinding spotifyPageBinding;
    private final SpotifyTrackListAdapter spotifyTrackListAdapter;
    private final List<Integer> stateMachine;
    private CountDownTimer timer;
    public static final Companion Companion = new Companion(null);
    private static final Map<String, String> mapGenre = MapsKt.mapOf(TuplesKt.to("top", "Топ-100"), TuplesKt.to("pop", "Поп"), TuplesKt.to("rock", "Рок"), TuplesKt.to("indie", "Инди"), TuplesKt.to("jazz", "Джаз/Кантри"), TuplesKt.to("rnb", "RnB"), TuplesKt.to("chanson", "Шансон"), TuplesKt.to("rap", "Рэп и хип-хоп"), TuplesKt.to("electronic", "Электроника"), TuplesKt.to("classic", "Классическая"), TuplesKt.to("delorenzy", "Делорензи"), TuplesKt.to("phonk", "Phonk"), TuplesKt.to("nfs", "NFS"), TuplesKt.to("radio", "Радио"), TuplesKt.to("favourites", "Избранное"));
    private static final Map<String, Integer> mapImage = MapsKt.mapOf(TuplesKt.to("top", Integer.valueOf(R.drawable.horizontal_refresh)), TuplesKt.to("pop", Integer.valueOf(R.drawable.spotify_pop_ic)), TuplesKt.to("rock", Integer.valueOf(R.drawable.spotify_rock_icon)), TuplesKt.to("indie", Integer.valueOf(R.drawable.spotify_indi_icon)), TuplesKt.to("jazz", Integer.valueOf(R.drawable.spotify_jazz_icon)), TuplesKt.to("rnb", Integer.valueOf(R.drawable.spotify_rnb_icon)), TuplesKt.to("chanson", Integer.valueOf(R.drawable.spotify_chanson_icon)), TuplesKt.to("rap", Integer.valueOf(R.drawable.spotify_rap_icon)), TuplesKt.to("electronic", Integer.valueOf(R.drawable.spotify_electronic_icon)), TuplesKt.to("classic", Integer.valueOf(R.drawable.spotify_classic_icon)), TuplesKt.to("delorenzy", Integer.valueOf(R.drawable.spotify_delorenzy_icon)), TuplesKt.to("phonk", Integer.valueOf(R.drawable.spotify_phonk_icon)), TuplesKt.to("nfs", Integer.valueOf(R.drawable.spotify_nfs_icon)), TuplesKt.to("radio", Integer.valueOf(R.drawable.spotify_radio_icon)), TuplesKt.to("favourites", Integer.valueOf(R.drawable.spotify_favourites_icon)));

    public SpotifyPage() {
        Retrofit build = new Retrofit.Builder().baseUrl(FirebaseConfigHelper.INSTANCE.getServerApiUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.retrofit = build;
        this.api = (SpotifyApi) build.create(SpotifyApi.class);
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MOBILE_PHONE_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.MobilePhone");
        MobilePhone mobilePhone = (MobilePhone) orCreatePage;
        this.mobilePhone = mobilePhone;
        Activity context = mobilePhone.getContext();
        this.mobileContext = context;
        MobilePhoneBinding binding = mobilePhone.getBinding();
        this.phoneBinding = binding;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        IBackendNotifier iBackendNotifier = (IBackendNotifier) context;
        this.sendFrontedMessage = iBackendNotifier;
        View inflate = context.getLayoutInflater().inflate(R.layout.mobile_phone_spotify_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.spotifyPage = constraintLayout;
        final MobilePhoneSpotifyPageBinding bind = MobilePhoneSpotifyPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.spotifyPageBinding = bind;
        List<Integer> mutableListOf = CollectionsKt.mutableListOf(Integer.valueOf(SpotifyState.INIT.getStateId()));
        this.stateMachine = mutableListOf;
        SpotifyGenreAdapter spotifyGenreAdapter = new SpotifyGenreAdapter();
        this.spotifyGenreAdapter = spotifyGenreAdapter;
        SpotifyTrackListAdapter spotifyTrackListAdapter = new SpotifyTrackListAdapter();
        this.spotifyTrackListAdapter = spotifyTrackListAdapter;
        HistoryManager.Companion.push(MobilePhonePage.SPOTIFY_PAGE.getId());
        constraintLayout.setVisibility(8);
        binding.phoneBackground.setBackground(ContextCompat.getDrawable(context, R.drawable.spotify_bg));
        bind.mpSpotifyPage.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        binding.phoneCaseContainer.addView(bind.mpSpotifyPage);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.phoneCaseContainer);
        constraintSet.connect(bind.mpSpotifyPage.getId(), 1, binding.phoneCaseContainer.getId(), 1);
        constraintSet.connect(bind.mpSpotifyPage.getId(), 2, binding.phoneCaseContainer.getId(), 2);
        constraintSet.connect(bind.mpSpotifyPage.getId(), 3, binding.phoneTopBarContainer.getId(), 4);
        constraintSet.applyTo(binding.phoneCaseContainer);
        playerInfoVisible(false);
        bind.mpSpotifyTracklist.setLayoutManager(new GridLayoutManager((Context) context, 3, 1, false));
        bind.mpSpotifyTracklist.setAdapter(spotifyGenreAdapter);
        bind.spotifyTrackList.setAdapter(spotifyTrackListAdapter);
        bind.spotifyTrackList.setLayoutManager(new LinearLayoutManager(context, 1, false));
        bind.mpSpotifyBackArrow.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyPage.lambda$4$lambda$0(SpotifyPage.this, view);
            }
        });
        iBackendNotifier.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), 0, 22);
        bind.mpSpotifyLogoBackArrow.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyPage.lambda$4$lambda$1(SpotifyPage.this, view);
            }
        });
        bind.mpSpotifyPlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyPage.lambda$4$lambda$3(MobilePhoneSpotifyPageBinding.this, this, view);
            }
        });
        spotifyTrackListAdapter.setOnFavouriteClickListener(new SpotifyTrackListAdapter.OnFavouriteClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$1$4
            @Override // ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyTrackListAdapter.OnFavouriteClickListener
            public void callback(int i, boolean z) {
                if (z) {
                    SpotifyPage.this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 20);
                } else {
                    SpotifyPage.this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 19);
                }
            }
        });
        bind.mpSpotifySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$1$5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Integer num;
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                try {
                    SpotifyPage spotifyPage = SpotifyPage.this;
                    for (Object obj : SpotifyPage.this.spotifyTrackListAdapter.getCurrentTrackList()) {
                        int id = ((SpotifyTrackResponse) obj).getId();
                        num = spotifyPage.playingTrackId;
                        if (num != null && id == num.intValue()) {
                            SpotifyTrackResponse spotifyTrackResponse = (SpotifyTrackResponse) obj;
                            int floor = (int) Math.floor((spotifyTrackResponse.getDuration() / 100.0d) * seekBar.getProgress());
                            IBackendNotifier iBackendNotifier2 = SpotifyPage.this.sendFrontedMessage;
                            int id2 = UIElementID.ARIZONA_MOBILE_PHONE.getId();
                            int id3 = spotifyTrackResponse.getId();
                            int id4 = spotifyTrackResponse.getId();
                            byte[] bytes = (id4 + StringUtils.COMMA + floor + StringUtils.COMMA + SpotifyPage.this.currentCategoryId).getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            iBackendNotifier2.clickedWrapper(id2, id3, 17, bytes);
                            SpotifyPage.this.addPlayedTrack(spotifyTrackResponse.getId(), floor);
                            return;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("SpotifyPage", "onStopTrackingTouch");
                }
            }
        });
        spotifyGenreAdapter.setOnGenreClickListener(new SpotifyGenreAdapter.OnGenreClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage.2
            @Override // ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyGenreAdapter.OnGenreClickListener
            public void callback(final String genre, int i) {
                Drawable drawable;
                Intrinsics.checkNotNullParameter(genre, "genre");
                SpotifyPage spotifyPage = SpotifyPage.this;
                spotifyPage.currentCategoryId = spotifyPage.getCategoryIdByName(genre);
                if (Intrinsics.areEqual(genre, "favourites")) {
                    SpotifyPage.this.spotifyTrackListAdapter.clearTrackList();
                    Call<List<SpotifyTrackResponse>> trackListByFavourites = SpotifyPage.this.api.getTrackListByFavourites(SpotifyPage.this.spotifyTrackListAdapter.getFavourites());
                    final SpotifyPage spotifyPage2 = SpotifyPage.this;
                    trackListByFavourites.enqueue((Callback) new Callback<List<? extends SpotifyTrackResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$2$callback$1
                        @Override // retrofit2.Callback
                        public void onResponse(Call<List<? extends SpotifyTrackResponse>> call, Response<List<? extends SpotifyTrackResponse>> response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            List<? extends SpotifyTrackResponse> body = response.body();
                            if (body != null) {
                                SpotifyPage spotifyPage3 = SpotifyPage.this;
                                String str = genre;
                                spotifyPage3.spotifyTrackListAdapter.clearTrackList();
                                int i2 = 0;
                                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, body.size() - 1, 20);
                                if (progressionLastElement >= 0) {
                                    while (true) {
                                        int i3 = i2 + 20;
                                        spotifyPage3.spotifyTrackListAdapter.addTrackList(CollectionsKt.slice((List) body, RangesKt.until(i2, RangesKt.coerceAtMost(i3, body.size()))), str);
                                        if (i2 == progressionLastElement) {
                                            break;
                                        }
                                        i2 = i3;
                                    }
                                }
                                spotifyPage3.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), spotifyPage3.currentCategoryId, 23);
                            }
                        }

                        @Override // retrofit2.Callback
                        public void onFailure(Call<List<? extends SpotifyTrackResponse>> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            Log.w("SpotifyPage", "error get favourite tracks");
                        }
                    });
                } else {
                    Call<List<SpotifyTrackResponse>> trackListByCategory = SpotifyPage.this.api.getTrackListByCategory(genre);
                    final SpotifyPage spotifyPage3 = SpotifyPage.this;
                    trackListByCategory.enqueue((Callback) new Callback<List<? extends SpotifyTrackResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$2$callback$2
                        @Override // retrofit2.Callback
                        public void onResponse(Call<List<? extends SpotifyTrackResponse>> call, Response<List<? extends SpotifyTrackResponse>> response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            List<? extends SpotifyTrackResponse> body = response.body();
                            if (body != null) {
                                SpotifyPage spotifyPage4 = SpotifyPage.this;
                                String str = genre;
                                spotifyPage4.spotifyTrackListAdapter.clearTrackList();
                                int i2 = 0;
                                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, body.size() - 1, 20);
                                if (progressionLastElement >= 0) {
                                    while (true) {
                                        int i3 = i2 + 20;
                                        spotifyPage4.spotifyTrackListAdapter.addTrackList(CollectionsKt.slice((List) body, RangesKt.until(i2, RangesKt.coerceAtMost(i3, body.size()))), str);
                                        if (i2 == progressionLastElement) {
                                            break;
                                        }
                                        i2 = i3;
                                    }
                                }
                                spotifyPage4.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), spotifyPage4.currentCategoryId, 23);
                            }
                        }

                        @Override // retrofit2.Callback
                        public void onFailure(Call<List<? extends SpotifyTrackResponse>> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            Log.w("SpotifyPage", "error get track category");
                        }
                    });
                }
                MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding = SpotifyPage.this.spotifyPageBinding;
                SpotifyPage spotifyPage4 = SpotifyPage.this;
                mobilePhoneSpotifyPageBinding.mpSpotifyLogoTitle.setText(SpotifyPage.Companion.getMapGenre().get(genre));
                AppCompatImageView appCompatImageView = mobilePhoneSpotifyPageBinding.mpSpotifyLogoImg;
                Integer num = SpotifyPage.Companion.getMapImage().get(genre);
                if (num != null) {
                    drawable = ContextCompat.getDrawable(spotifyPage4.mobileContext, num.intValue());
                } else {
                    drawable = null;
                }
                appCompatImageView.setImageDrawable(drawable);
                SpotifyPage.this.stateMachine.set(0, Integer.valueOf(SpotifyState.CATEGORY_TRACK_LIST.getStateId()));
                SpotifyPage spotifyPage5 = SpotifyPage.this;
                spotifyPage5.spotifyState(((Number) spotifyPage5.stateMachine.get(0)).intValue());
            }
        });
        spotifyTrackListAdapter.setOnPlayTrackClickListener(new SpotifyTrackListAdapter.OnPlayTrackClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage.3
            @Override // ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyTrackListAdapter.OnPlayTrackClickListener
            public void callback(int i, boolean z) {
                if (SpotifyPage.this.timer != null) {
                    CountDownTimer countDownTimer = SpotifyPage.this.timer;
                    if (countDownTimer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timer");
                        countDownTimer = null;
                    }
                    countDownTimer.cancel();
                }
                if (z) {
                    SpotifyPage.this.currentTrackProgressInSec = 0;
                }
                if (!SpotifyPage.isTrackPlaying || z) {
                    IBackendNotifier iBackendNotifier2 = SpotifyPage.this.sendFrontedMessage;
                    int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
                    int i2 = SpotifyPage.this.currentTrackProgressInSec;
                    byte[] bytes = (i + StringUtils.COMMA + i2 + StringUtils.COMMA + SpotifyPage.this.currentCategoryId).getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    iBackendNotifier2.clickedWrapper(id, i, 17, bytes);
                    Companion companion = SpotifyPage.Companion;
                    SpotifyPage.isTrackPlaying = true;
                    SpotifyPage.this.spotifyPageBinding.mpSpotifySeekBar.setProgress(0);
                    SpotifyPage.this.spotifyPageBinding.mpSpotifyPlay.setImageResource(R.drawable.spotify_play_off);
                    if (Intrinsics.areEqual(SpotifyPage.this.spotifyPageBinding.mpSpotifyLogoTitle.getText(), "Радио")) {
                        SpotifyPage.this.playRadio(i);
                        SpotifyPage.this.spotifyPageBinding.mpSpotifySeekBar.setVisibility(8);
                    } else {
                        SpotifyPage spotifyPage = SpotifyPage.this;
                        spotifyPage.addPlayedTrack(i, spotifyPage.currentTrackProgressInSec);
                        SpotifyPage.this.spotifyPageBinding.mpSpotifySeekBar.setVisibility(0);
                    }
                } else {
                    SpotifyPage.this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 18);
                    Companion companion2 = SpotifyPage.Companion;
                    SpotifyPage.isTrackPlaying = false;
                    SpotifyPage.this.spotifyPageBinding.mpSpotifyPlay.setImageResource(R.drawable.spotify_play_on);
                }
                SpotifyPage.this.playingTrackId = Integer.valueOf(i);
            }
        });
        spotifyState(mutableListOf.get(0).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$0(SpotifyPage spotifyPage, View view) {
        if (spotifyPage.stateMachine.get(0).intValue() != SpotifyState.INIT.getStateId()) {
            spotifyPage.stateMachine.set(0, Integer.valueOf(SpotifyState.INIT.getStateId()));
            spotifyPage.spotifyState(spotifyPage.stateMachine.get(0).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$1(SpotifyPage spotifyPage, View view) {
        if (spotifyPage.stateMachine.get(0).intValue() != SpotifyState.INIT.getStateId()) {
            spotifyPage.stateMachine.set(0, Integer.valueOf(SpotifyState.INIT.getStateId()));
            spotifyPage.spotifyState(spotifyPage.stateMachine.get(0).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$4$lambda$3(MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding, SpotifyPage spotifyPage, View view) {
        mobilePhoneSpotifyPageBinding.mpSpotifyPlay.setImageResource(isTrackPlaying ? R.drawable.spotify_play_on : R.drawable.spotify_play_off);
        Integer num = spotifyPage.playingTrackId;
        if (num != null) {
            int intValue = num.intValue();
            if (isTrackPlaying) {
                IBackendNotifier iBackendNotifier = spotifyPage.sendFrontedMessage;
                int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
                byte[] bytes = (intValue + StringUtils.COMMA + spotifyPage.currentCategoryId).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                iBackendNotifier.clickedWrapper(id, intValue, 18, bytes);
                CountDownTimer countDownTimer = spotifyPage.timer;
                if (countDownTimer != null) {
                    if (countDownTimer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timer");
                        countDownTimer = null;
                    }
                    countDownTimer.cancel();
                }
            } else {
                IBackendNotifier iBackendNotifier2 = spotifyPage.sendFrontedMessage;
                int id2 = UIElementID.ARIZONA_MOBILE_PHONE.getId();
                byte[] bytes2 = (intValue + StringUtils.COMMA + spotifyPage.currentTrackProgressInSec + StringUtils.COMMA + spotifyPage.currentCategoryId).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                iBackendNotifier2.clickedWrapper(id2, intValue, 17, bytes2);
                spotifyPage.addPlayedTrack(intValue, spotifyPage.currentTrackProgressInSec);
            }
            isTrackPlaying = !isTrackPlaying;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCategoryIdByName(String str) {
        switch (str.hashCode()) {
            case -1785238953:
                return !str.equals("favorites") ? 0 : 15;
            case -74249770:
                return !str.equals("delorenzy") ? 0 : 12;
            case 108987:
                return !str.equals("nfs") ? 0 : 13;
            case 111185:
                return !str.equals("pop") ? 0 : 2;
            case 112673:
                return !str.equals("rap") ? 0 : 11;
            case 113062:
                return !str.equals("rnb") ? 0 : 4;
            case 115029:
                return !str.equals("top") ? 0 : 1;
            case 3254967:
                return !str.equals("jazz") ? 0 : 9;
            case 3506021:
                return !str.equals("rock") ? 0 : 8;
            case 100346171:
                return !str.equals("indie") ? 0 : 3;
            case 106642804:
                return !str.equals("phonk") ? 0 : 7;
            case 108270587:
                return !str.equals("radio") ? 0 : 14;
            case 723833468:
                return !str.equals("electronic") ? 0 : 5;
            case 738955520:
                return !str.equals("chanson") ? 0 : 10;
            case 853620882:
                return !str.equals("classic") ? 0 : 6;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void spotifyState(int i) {
        hideAllDynamicView();
        if (i == SpotifyState.INIT.getStateId()) {
            MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding = this.spotifyPageBinding;
            mobilePhoneSpotifyPageBinding.mpSpotifyLogoContainer.setVisibility(0);
            mobilePhoneSpotifyPageBinding.mpSpotifyZoom.setVisibility(0);
            mobilePhoneSpotifyPageBinding.mpSpotifyTitle.setVisibility(0);
            mobilePhoneSpotifyPageBinding.mpSpotifyTracklist.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = mobilePhoneSpotifyPageBinding.mpSpotifyHeader.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ConverterKt.dpToPx(16, this.mobileContext);
            mobilePhoneSpotifyPageBinding.mpSpotifyTracklist.setVisibility(0);
            if (mobilePhoneSpotifyPageBinding.mpSpotifyTracklist.getLayoutManager() == null) {
                mobilePhoneSpotifyPageBinding.mpSpotifyTracklist.setLayoutManager(new GridLayoutManager((Context) this.mobileContext, 3, 1, false));
                mobilePhoneSpotifyPageBinding.mpSpotifyTracklist.setAdapter(this.spotifyGenreAdapter);
            }
            mobilePhoneSpotifyPageBinding.mpSpotifyZoom.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpotifyPage.spotifyState$lambda$6$lambda$5(SpotifyPage.this, view);
                }
            });
            ViewGroup.LayoutParams layoutParams2 = mobilePhoneSpotifyPageBinding.mpSpotifyFoundTrackListContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams2.height = ConverterKt.dpToPx(200, this.mobileContext);
        } else if (i == SpotifyState.SEARCH.getStateId()) {
            final MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding2 = this.spotifyPageBinding;
            mobilePhoneSpotifyPageBinding2.mpSpotifyBack.setVisibility(0);
            mobilePhoneSpotifyPageBinding2.mpSpotifySearchInputContainer.setVisibility(0);
            mobilePhoneSpotifyPageBinding2.mpSpotifyTracklist.setVisibility(0);
            mobilePhoneSpotifyPageBinding2.mpSpotifyBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpotifyPage.spotifyState$lambda$10$lambda$7(SpotifyPage.this, view);
                }
            });
            ViewGroup.LayoutParams layoutParams3 = mobilePhoneSpotifyPageBinding2.spotifyTrackList.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams3.height = ConverterKt.dpToPx(200, this.mobileContext);
            ViewGroup.LayoutParams layoutParams4 = mobilePhoneSpotifyPageBinding2.mpSpotifyFoundTrackListContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams4.height = ConverterKt.dpToPx(200, this.mobileContext);
            mobilePhoneSpotifyPageBinding2.mpSpotifySearchClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpotifyPage.spotifyState$lambda$10$lambda$8(MobilePhoneSpotifyPageBinding.this, view);
                }
            });
            mobilePhoneSpotifyPageBinding2.mpSpotifySearchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$$ExternalSyntheticLambda3
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    boolean spotifyState$lambda$10$lambda$9;
                    spotifyState$lambda$10$lambda$9 = SpotifyPage.spotifyState$lambda$10$lambda$9(SpotifyPage.this, mobilePhoneSpotifyPageBinding2, textView, i2, keyEvent);
                    return spotifyState$lambda$10$lambda$9;
                }
            });
        } else if (i == SpotifyState.TRACK_LIST.getStateId()) {
            MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding3 = this.spotifyPageBinding;
            mobilePhoneSpotifyPageBinding3.mpSpotifyLogoContainer.setVisibility(0);
            mobilePhoneSpotifyPageBinding3.mpSpotifyLogoBackArrow.setVisibility(0);
            mobilePhoneSpotifyPageBinding3.mpSpotifyFoundTrackListTitle.setVisibility(8);
            mobilePhoneSpotifyPageBinding3.spotifyTrackList.setVisibility(0);
            ViewGroup.LayoutParams layoutParams5 = mobilePhoneSpotifyPageBinding3.spotifyTrackList.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams5.height = ConverterKt.dpToPx(200, this.mobileContext);
        } else if (i == SpotifyState.CATEGORY_TRACK_LIST.getStateId()) {
            MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding4 = this.spotifyPageBinding;
            mobilePhoneSpotifyPageBinding4.mpSpotifyLogoContainer.setVisibility(0);
            mobilePhoneSpotifyPageBinding4.mpSpotifyLogoBackArrow.setVisibility(0);
            mobilePhoneSpotifyPageBinding4.mpSpotifyFoundTrackListTitle.setVisibility(8);
            mobilePhoneSpotifyPageBinding4.spotifyTrackList.setVisibility(0);
            ViewGroup.LayoutParams layoutParams6 = mobilePhoneSpotifyPageBinding4.spotifyTrackList.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams6.height = ConverterKt.dpToPx(200, this.mobileContext);
            ViewGroup.LayoutParams layoutParams7 = mobilePhoneSpotifyPageBinding4.mpSpotifyFoundTrackListContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams7.height = ConverterKt.dpToPx(200, this.mobileContext);
            ViewGroup.LayoutParams layoutParams8 = mobilePhoneSpotifyPageBinding4.mpSpotifyLogoBackArrow.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = ConverterKt.dpToPx(4, this.mobileContext);
            ViewGroup.LayoutParams layoutParams9 = mobilePhoneSpotifyPageBinding4.mpSpotifyLogoContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = ConverterKt.dpToPx(4, this.mobileContext);
            ViewGroup.LayoutParams layoutParams10 = mobilePhoneSpotifyPageBinding4.mpSpotifyZoom.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams10, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = ConverterKt.dpToPx(4, this.mobileContext);
        }
        this.stateMachine.set(0, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void spotifyState$lambda$6$lambda$5(SpotifyPage spotifyPage, View view) {
        spotifyPage.stateMachine.set(0, Integer.valueOf(SpotifyState.SEARCH.getStateId()));
        spotifyPage.spotifyState(spotifyPage.stateMachine.get(0).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void spotifyState$lambda$10$lambda$7(SpotifyPage spotifyPage, View view) {
        spotifyPage.spotifyState(SpotifyState.INIT.getStateId());
        spotifyPage.stateMachine.set(0, Integer.valueOf(SpotifyState.INIT.getStateId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void spotifyState$lambda$10$lambda$8(MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding, View view) {
        mobilePhoneSpotifyPageBinding.mpSpotifySearchInput.getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean spotifyState$lambda$10$lambda$9(final SpotifyPage spotifyPage, final MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            spotifyPage.api.searchTrackListByParam(textView.getText().toString()).enqueue((Callback) new Callback<List<? extends SpotifyTrackResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$spotifyState$2$3$1
                @Override // retrofit2.Callback
                public void onResponse(Call<List<? extends SpotifyTrackResponse>> call, Response<List<? extends SpotifyTrackResponse>> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    List<? extends SpotifyTrackResponse> body = response.body();
                    if (body != null) {
                        SpotifyPage spotifyPage2 = SpotifyPage.this;
                        MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding2 = mobilePhoneSpotifyPageBinding;
                        spotifyPage2.spotifyTrackListAdapter.clearTrackList();
                        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, body.size() - 1, 20);
                        if (progressionLastElement >= 0) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2 + 20;
                                spotifyPage2.spotifyTrackListAdapter.addTrackList(CollectionsKt.slice((List) body, RangesKt.until(i2, RangesKt.coerceAtMost(i3, body.size()))), "");
                                if (i2 == progressionLastElement) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                        mobilePhoneSpotifyPageBinding2.mpSpotifyTracklist.setVisibility(8);
                        mobilePhoneSpotifyPageBinding2.spotifyTrackList.setVisibility(0);
                        ViewGroup.LayoutParams layoutParams = mobilePhoneSpotifyPageBinding2.spotifyTrackList.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        layoutParams.height = ConverterKt.dpToPx(200, spotifyPage2.mobileContext);
                        ViewGroup.LayoutParams layoutParams2 = mobilePhoneSpotifyPageBinding2.mpSpotifyFoundTrackListContainer.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        layoutParams2.height = ConverterKt.dpToPx(200, spotifyPage2.mobileContext);
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<List<? extends SpotifyTrackResponse>> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.w("SpotifyPage", "error search track");
                }
            });
            return false;
        }
        return false;
    }

    private final void hideAllDynamicView() {
        MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding = this.spotifyPageBinding;
        mobilePhoneSpotifyPageBinding.mpSpotifyLogoContainer.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifyLogoBackArrow.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifyZoom.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifyTitle.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifyTracklist.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = mobilePhoneSpotifyPageBinding.mpSpotifyHeader.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
        mobilePhoneSpotifyPageBinding.mpSpotifyBack.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifySearchInputContainer.setVisibility(8);
        ViewGroup.LayoutParams layoutParams2 = mobilePhoneSpotifyPageBinding.spotifyTrackList.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams2.height = ConverterKt.dpToPx(200, this.mobileContext);
        mobilePhoneSpotifyPageBinding.spotifyTrackList.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifyLogoTitle.setText("azpotify");
        mobilePhoneSpotifyPageBinding.mpSpotifyLogoImg.setImageDrawable(ContextCompat.getDrawable(this.mobileContext, R.drawable.spotify_logo));
        ViewGroup.LayoutParams layoutParams3 = mobilePhoneSpotifyPageBinding.mpSpotifyLogoBackArrow.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = ConverterKt.dpToPx(0, this.mobileContext);
        ViewGroup.LayoutParams layoutParams4 = mobilePhoneSpotifyPageBinding.mpSpotifyLogoContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ConverterKt.dpToPx(0, this.mobileContext);
        ViewGroup.LayoutParams layoutParams5 = mobilePhoneSpotifyPageBinding.mpSpotifyZoom.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = ConverterKt.dpToPx(0, this.mobileContext);
        if (this.timer == null) {
            mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setVisibility(8);
        }
    }

    public final void initFavourite(List<Integer> favouriteList) {
        Intrinsics.checkNotNullParameter(favouriteList, "favouriteList");
        this.spotifyTrackListAdapter.addFavourites(favouriteList);
    }

    public final void addToFavourite(int i) {
        this.spotifyTrackListAdapter.addFavourites(CollectionsKt.listOf(Integer.valueOf(i)));
    }

    public final void removeFromFavourite(int i) {
        this.spotifyTrackListAdapter.removeFromFavourite(i);
    }

    public final void changeArtistNameRadio(List<ChangeArtistNameRadioRequest> changeArtistNameRadioRequest) {
        Intrinsics.checkNotNullParameter(changeArtistNameRadioRequest, "changeArtistNameRadioRequest");
        this.spotifyTrackListAdapter.changeArtistNameRadio(changeArtistNameRadioRequest);
    }

    public final void playRadio(int i) {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        for (SpotifyTrackResponse spotifyTrackResponse : this.spotifyTrackListAdapter.getCurrentTrackList()) {
            if (spotifyTrackResponse.getId() == i) {
                MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding = this.spotifyPageBinding;
                mobilePhoneSpotifyPageBinding.mpSpotifySingerName.setText(spotifyTrackResponse.getSongName());
                mobilePhoneSpotifyPageBinding.mpSpotifySongName.setText("");
                mobilePhoneSpotifyPageBinding.mpSpotifySongTime.setText("live");
                mobilePhoneSpotifyPageBinding.mpSpotifySongTime.setVisibility(0);
                mobilePhoneSpotifyPageBinding.mpSpotifySongLive.setVisibility(0);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r0.isEmpty() != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addPlayedTrack(final int i, final int i2) {
        Exception exc;
        final ArrayList arrayList;
        try {
            CountDownTimer countDownTimer = this.timer;
            if (countDownTimer != null) {
                if (countDownTimer == null) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("timer");
                        countDownTimer = null;
                    } catch (Exception e) {
                        exc = e;
                        exc.printStackTrace();
                        Log.d("SpotifyPage", "addPlayedTrack");
                    }
                }
                countDownTimer.cancel();
            }
            this.playingTrackId = Integer.valueOf(i);
            arrayList = new ArrayList();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (!this.spotifyTrackListAdapter.getCurrentTrackList().isEmpty()) {
                List<SpotifyTrackResponse> currentTrackList = this.spotifyTrackListAdapter.getCurrentTrackList();
                if (currentTrackList instanceof Collection) {
                }
                for (SpotifyTrackResponse spotifyTrackResponse : currentTrackList) {
                    if (spotifyTrackResponse.getId() == i) {
                        for (Object obj : this.spotifyTrackListAdapter.getCurrentTrackList()) {
                            if (((SpotifyTrackResponse) obj).getId() == i) {
                                final SpotifyTrackResponse spotifyTrackResponse2 = (SpotifyTrackResponse) obj;
                                final MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding = this.spotifyPageBinding;
                                mobilePhoneSpotifyPageBinding.mpSpotifySingerName.setText(spotifyTrackResponse2.getArtistName());
                                mobilePhoneSpotifyPageBinding.mpSpotifySongName.setText(spotifyTrackResponse2.getSongName());
                                mobilePhoneSpotifyPageBinding.mpSpotifySongLive.setVisibility(8);
                                final double duration = 100.0d / spotifyTrackResponse2.getDuration();
                                playerInfoVisible(true);
                                final Ref.IntRef intRef = new Ref.IntRef();
                                mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setVisibility(0);
                                final Ref.DoubleRef doubleRef = new Ref.DoubleRef();
                                doubleRef.element = i2 * duration;
                                mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setProgress((int) Math.floor(doubleRef.element));
                                this.spotifyPageBinding.mpSpotifyPlay.setImageResource(R.drawable.spotify_play_off);
                                this.currentTrackProgressInSec = i2;
                                final long duration2 = (spotifyTrackResponse2.getDuration() - i2) * 1000;
                                CountDownTimer countDownTimer2 = new CountDownTimer(duration2) { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$addPlayedTrack$3$1
                                    @Override // android.os.CountDownTimer
                                    public void onTick(long j) {
                                        SpotifyPage.this.currentTrackProgressInSec++;
                                        intRef.element += 1000;
                                        doubleRef.element += duration;
                                        mobilePhoneSpotifyPageBinding.mpSpotifySongTime.setText(((((i2 * 1000) + intRef.element) / 1000) / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + ((((i2 * 1000) + intRef.element) / 1000) % 60));
                                        mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setProgress((int) Math.floor(doubleRef.element));
                                    }

                                    @Override // android.os.CountDownTimer
                                    public void onFinish() {
                                        SpotifyPage.this.playerInfoVisible(false);
                                        int indexOf = arrayList.indexOf(spotifyTrackResponse2) + 1;
                                        if (indexOf < arrayList.size()) {
                                            mobilePhoneSpotifyPageBinding.mpSpotifySeekBar.setProgress(0);
                                            IBackendNotifier iBackendNotifier = SpotifyPage.this.sendFrontedMessage;
                                            int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
                                            int id2 = arrayList.get(indexOf).getId();
                                            int id3 = arrayList.get(indexOf).getId();
                                            byte[] bytes = (id3 + ",0," + SpotifyPage.this.currentCategoryId).getBytes(Charsets.UTF_8);
                                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                            iBackendNotifier.clickedWrapper(id, id2, 17, bytes);
                                            SpotifyPage.Companion companion = SpotifyPage.Companion;
                                            SpotifyPage.isTrackPlaying = true;
                                            SpotifyPage.this.playingTrackId = Integer.valueOf(arrayList.get(indexOf).getId());
                                            SpotifyPage.this.addPlayedTrack(arrayList.get(indexOf).getId(), 0);
                                        }
                                    }
                                };
                                this.timer = countDownTimer2;
                                countDownTimer2.start();
                                return;
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
            }
            this.api.getTrackListByFavourites(CollectionsKt.listOf(Integer.valueOf(i))).enqueue((Callback) new Callback<List<? extends SpotifyTrackResponse>>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$addPlayedTrack$2
                @Override // retrofit2.Callback
                public void onResponse(Call<List<? extends SpotifyTrackResponse>> call, Response<List<? extends SpotifyTrackResponse>> response) {
                    CountDownTimer countDownTimer3;
                    Object obj2;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    List<? extends SpotifyTrackResponse> body = response.body();
                    if (body != null) {
                        final SpotifyPage spotifyPage = SpotifyPage.this;
                        int i3 = i;
                        final int i4 = i2;
                        final ArrayList<SpotifyTrackResponse> arrayList2 = arrayList;
                        Iterator<T> it = body.iterator();
                        while (true) {
                            countDownTimer3 = null;
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            if (((SpotifyTrackResponse) obj2).getId() == i3) {
                                break;
                            }
                        }
                        final SpotifyTrackResponse spotifyTrackResponse3 = (SpotifyTrackResponse) obj2;
                        final MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding2 = spotifyPage.spotifyPageBinding;
                        mobilePhoneSpotifyPageBinding2.mpSpotifySingerName.setText(spotifyTrackResponse3 != null ? spotifyTrackResponse3.getArtistName() : null);
                        mobilePhoneSpotifyPageBinding2.mpSpotifySongName.setText(spotifyTrackResponse3 != null ? spotifyTrackResponse3.getSongName() : null);
                        mobilePhoneSpotifyPageBinding2.mpSpotifySongLive.setVisibility(8);
                        Integer valueOf = spotifyTrackResponse3 != null ? Integer.valueOf((spotifyTrackResponse3.getDuration() - i4) * 1000) : null;
                        final double duration3 = 100.0d / (spotifyTrackResponse3 != null ? spotifyTrackResponse3.getDuration() : 0);
                        spotifyPage.playerInfoVisible(true);
                        final Ref.IntRef intRef2 = new Ref.IntRef();
                        mobilePhoneSpotifyPageBinding2.mpSpotifySeekBar.setVisibility(0);
                        final Ref.DoubleRef doubleRef2 = new Ref.DoubleRef();
                        doubleRef2.element = i4 * duration3;
                        mobilePhoneSpotifyPageBinding2.mpSpotifySeekBar.setProgress((int) Math.floor(doubleRef2.element));
                        spotifyPage.spotifyPageBinding.mpSpotifyPlay.setImageResource(R.drawable.spotify_play_off);
                        spotifyPage.currentTrackProgressInSec = i4;
                        final long intValue = valueOf != null ? valueOf.intValue() : 0L;
                        spotifyPage.timer = new CountDownTimer(intValue) { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage$addPlayedTrack$2$onResponse$1$1$1
                            @Override // android.os.CountDownTimer
                            public void onTick(long j) {
                                SpotifyPage.this.currentTrackProgressInSec++;
                                intRef2.element += 1000;
                                doubleRef2.element += duration3;
                                mobilePhoneSpotifyPageBinding2.mpSpotifySongTime.setText(((((i4 * 1000) + intRef2.element) / 1000) / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + ((((i4 * 1000) + intRef2.element) / 1000) % 60));
                                mobilePhoneSpotifyPageBinding2.mpSpotifySeekBar.setProgress((int) Math.floor(doubleRef2.element));
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                SpotifyPage.this.playerInfoVisible(false);
                                int indexOf = CollectionsKt.indexOf((List<? extends SpotifyTrackResponse>) arrayList2, spotifyTrackResponse3) + 1;
                                if (indexOf < arrayList2.size()) {
                                    mobilePhoneSpotifyPageBinding2.mpSpotifySeekBar.setProgress(0);
                                    IBackendNotifier iBackendNotifier = SpotifyPage.this.sendFrontedMessage;
                                    int id = UIElementID.ARIZONA_MOBILE_PHONE.getId();
                                    int id2 = arrayList2.get(indexOf).getId();
                                    int id3 = arrayList2.get(indexOf).getId();
                                    byte[] bytes = (id3 + ",0," + SpotifyPage.this.currentCategoryId).getBytes(Charsets.UTF_8);
                                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                    iBackendNotifier.clickedWrapper(id, id2, 17, bytes);
                                    SpotifyPage.Companion companion = SpotifyPage.Companion;
                                    SpotifyPage.isTrackPlaying = true;
                                    SpotifyPage.this.playingTrackId = Integer.valueOf(arrayList2.get(indexOf).getId());
                                    SpotifyPage.this.addPlayedTrack(arrayList2.get(indexOf).getId(), 0);
                                }
                            }
                        };
                        CountDownTimer countDownTimer4 = spotifyPage.timer;
                        if (countDownTimer4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timer");
                        } else {
                            countDownTimer3 = countDownTimer4;
                        }
                        countDownTimer3.start();
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<List<? extends SpotifyTrackResponse>> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.d("SpotifyPage", "error get track by id");
                }
            });
        } catch (Exception e3) {
            e = e3;
            exc = e;
            exc.printStackTrace();
            Log.d("SpotifyPage", "addPlayedTrack");
        }
    }

    public final void playerInfoVisible(boolean z) {
        MobilePhoneSpotifyPageBinding mobilePhoneSpotifyPageBinding = this.spotifyPageBinding;
        if (z) {
            mobilePhoneSpotifyPageBinding.mpSpotifySingerName.setVisibility(0);
            mobilePhoneSpotifyPageBinding.mpSpotifySongName.setVisibility(0);
            mobilePhoneSpotifyPageBinding.mpSpotifySongTime.setVisibility(0);
            return;
        }
        mobilePhoneSpotifyPageBinding.mpSpotifySingerName.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifySongName.setVisibility(8);
        mobilePhoneSpotifyPageBinding.mpSpotifySongTime.setVisibility(8);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SpotifyPage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyPage$SpotifyState;", "", "stateId", "", "<init>", "(Ljava/lang/String;II)V", "getStateId", "()I", "INIT", "SEARCH", "TRACK_LIST", "CATEGORY_TRACK_LIST", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SpotifyState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SpotifyState[] $VALUES;
        private final int stateId;
        public static final SpotifyState INIT = new SpotifyState("INIT", 0, 0);
        public static final SpotifyState SEARCH = new SpotifyState("SEARCH", 1, 1);
        public static final SpotifyState TRACK_LIST = new SpotifyState("TRACK_LIST", 2, 2);
        public static final SpotifyState CATEGORY_TRACK_LIST = new SpotifyState("CATEGORY_TRACK_LIST", 3, 3);

        private static final /* synthetic */ SpotifyState[] $values() {
            return new SpotifyState[]{INIT, SEARCH, TRACK_LIST, CATEGORY_TRACK_LIST};
        }

        public static EnumEntries<SpotifyState> getEntries() {
            return $ENTRIES;
        }

        private SpotifyState(String str, int i, int i2) {
            this.stateId = i2;
        }

        public final int getStateId() {
            return this.stateId;
        }

        static {
            SpotifyState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static SpotifyState valueOf(String str) {
            return (SpotifyState) Enum.valueOf(SpotifyState.class, str);
        }

        public static SpotifyState[] values() {
            return (SpotifyState[]) $VALUES.clone();
        }
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
        this.spotifyPage.setVisibility(0);
        this.phoneBinding.phoneBackground.setBackground(ContextCompat.getDrawable(this.mobileContext, R.drawable.spotify_bg));
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        HistoryManager.Companion.clearThisPage(MobilePhonePage.SPOTIFY_PAGE.getId());
        this.spotifyPage.removeAllViews();
    }

    /* compiled from: SpotifyPage.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyPage$Companion;", "", "<init>", "()V", "isTrackPlaying", "", "mapGenre", "", "", "getMapGenre", "()Ljava/util/Map;", "mapImage", "", "getMapImage", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isTrackPlaying() {
            return SpotifyPage.isTrackPlaying;
        }

        public final Map<String, String> getMapGenre() {
            return SpotifyPage.mapGenre;
        }

        public final Map<String, Integer> getMapImage() {
            return SpotifyPage.mapImage;
        }
    }
}
