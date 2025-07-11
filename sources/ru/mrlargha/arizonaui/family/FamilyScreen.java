package ru.mrlargha.arizonaui.family;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FamilyCharterFrameBinding;
import ru.mrlargha.arizonaui.databinding.FamilyCharterMembersBinding;
import ru.mrlargha.arizonaui.databinding.FamilyCreateClanBinding;
import ru.mrlargha.arizonaui.databinding.FamilyHomePageBinding;
import ru.mrlargha.arizonaui.databinding.FamilyMainBinding;
import ru.mrlargha.arizonaui.databinding.FamilyMapFrameBinding;
import ru.mrlargha.arizonaui.databinding.FamilyMeetingsBinding;
import ru.mrlargha.arizonaui.databinding.FamilyMembersBinding;
import ru.mrlargha.arizonaui.databinding.FamilyMembersFrameBinding;
import ru.mrlargha.arizonaui.databinding.FamilyRatingBinding;
import ru.mrlargha.arizonaui.databinding.FamilyTerritoriesBinding;
import ru.mrlargha.arizonaui.databinding.FamilyTopbarBinding;
import ru.mrlargha.arizonaui.family.adapters.CharterAdapter;
import ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter;
import ru.mrlargha.arizonaui.family.adapters.CreateClanColorAdapter;
import ru.mrlargha.arizonaui.family.adapters.EstateAdapter;
import ru.mrlargha.arizonaui.family.adapters.MainMenuAdapter;
import ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter;
import ru.mrlargha.arizonaui.family.adapters.MembersAdapter;
import ru.mrlargha.arizonaui.family.adapters.RatingAdapter;
import ru.mrlargha.arizonaui.family.adapters.SettingsAdapter;
import ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter;
import ru.mrlargha.arizonaui.family.adapters.WarsAdapter;
import ru.mrlargha.arizonaui.family.data.CharterItem;
import ru.mrlargha.arizonaui.family.data.FamilyCharterData;
import ru.mrlargha.arizonaui.family.data.FamilyCreateData;
import ru.mrlargha.arizonaui.family.data.FamilyData;
import ru.mrlargha.arizonaui.family.data.FamilyEstateData;
import ru.mrlargha.arizonaui.family.data.FamilySettingsData;
import ru.mrlargha.arizonaui.family.data.FamilyWarData;
import ru.mrlargha.arizonaui.family.data.FlagsKt;
import ru.mrlargha.arizonaui.family.data.FrameMapData;
import ru.mrlargha.arizonaui.family.data.GangZoneItem;
import ru.mrlargha.arizonaui.family.data.Leader;
import ru.mrlargha.arizonaui.family.data.LogoKt;
import ru.mrlargha.arizonaui.family.data.MemberItem;
import ru.mrlargha.arizonaui.family.data.RatingItem;
import ru.mrlargha.arizonaui.family.data.ServersKt;
import ru.mrlargha.arizonaui.family.data.UniqCellItem;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0094\u0001\u0095\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001dH\u0016J\u0018\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\u0006H\u0016J\b\u0010G\u001a\u00020BH\u0002J\u0010\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020&H\u0002J\u0010\u0010J\u001a\u00020B2\u0006\u0010I\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020B2\u0006\u0010I\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020B2\u0006\u0010I\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020B2\u0006\u0010I\u001a\u00020QH\u0002J\u0016\u0010R\u001a\u00020B2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060SH\u0002J\u0010\u0010T\u001a\u00020B2\u0006\u0010I\u001a\u00020$H\u0002J\b\u0010U\u001a\u00020BH\u0002J\b\u0010V\u001a\u00020BH\u0002J\b\u0010W\u001a\u00020BH\u0002J\u0010\u0010X\u001a\u00020B2\u0006\u0010Y\u001a\u00020\u0006H\u0002J\u0010\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020\u0016H\u0002J\u0010\u0010\\\u001a\u00020B2\u0006\u0010Y\u001a\u00020\u0006H\u0002J\u0010\u0010]\u001a\u00020B2\u0006\u0010[\u001a\u00020\u0016H\u0002J\u0010\u0010^\u001a\u00020B2\u0006\u0010Y\u001a\u00020\u0006H\u0002J\b\u0010_\u001a\u00020BH\u0002J\b\u0010`\u001a\u00020BH\u0002J\b\u0010a\u001a\u00020BH\u0002J\b\u0010b\u001a\u00020BH\u0002J\b\u0010c\u001a\u00020BH\u0002J\u0016\u0010d\u001a\u00020B2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020e0SH\u0002J\b\u0010f\u001a\u00020BH\u0002J\u0010\u0010g\u001a\u00020B2\u0006\u0010E\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020kH\u0002J\u0018\u0010l\u001a\u00020B2\u0006\u0010m\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0016H\u0002J\b\u0010n\u001a\u00020BH\u0002J\b\u0010o\u001a\u00020BH\u0002J\b\u0010p\u001a\u00020BH\u0002J\u0010\u0010q\u001a\u00020B2\u0006\u0010j\u001a\u00020\u0006H\u0002J\u0010\u0010r\u001a\u00020B2\u0006\u0010j\u001a\u00020\u0006H\u0002J\u0010\u0010s\u001a\u00020B2\u0006\u0010j\u001a\u00020\u0006H\u0002J\u0010\u0010t\u001a\u00020B2\u0006\u0010j\u001a\u00020\u0006H\u0002J\u0010\u0010u\u001a\u00020B2\u0006\u0010j\u001a\u00020\u0006H\u0002J\u0010\u0010v\u001a\u00020B2\u0006\u0010j\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020B2\u0006\u0010j\u001a\u00020kH\u0002J\b\u0010y\u001a\u00020BH\u0002J\u0010\u0010z\u001a\u00020B2\u0006\u0010j\u001a\u00020hH\u0002J\b\u0010{\u001a\u00020BH\u0002J\b\u0010|\u001a\u00020BH\u0002J\b\u0010}\u001a\u00020BH\u0002J\b\u0010~\u001a\u00020BH\u0002J\t\u0010\u0080\u0001\u001a\u00020BH\u0002J\t\u0010\u0082\u0001\u001a\u00020BH\u0002J\t\u0010\u0084\u0001\u001a\u00020BH\u0002J\t\u0010\u0086\u0001\u001a\u00020BH\u0002J\t\u0010\u0088\u0001\u001a\u00020BH\u0002J\t\u0010\u008a\u0001\u001a\u00020BH\u0002J\t\u0010\u008c\u0001\u001a\u00020BH\u0002J\t\u0010\u008e\u0001\u001a\u00020BH\u0002J\t\u0010\u0090\u0001\u001a\u00020BH\u0002J\u0013\u0010\u0091\u0001\u001a\u00020B2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lru/mrlargha/arizonaui/family/FamilyScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/arizonaui/databinding/FamilyMainBinding;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sharedPref", "Landroid/content/SharedPreferences;", "serverId", "_token", "", "token", "getToken", "()Ljava/lang/String;", "createSelectedImage", "createSelectedImageMax", "createIsTitleDone", "", "createIsSloganDone", "mapCells", "xMargin", "", "yMargin", "familyData", "Lru/mrlargha/arizonaui/family/data/FamilyData;", "createInfo", "Lru/mrlargha/arizonaui/family/data/FamilyCreateData;", "colorsAdapter", "Lru/mrlargha/arizonaui/family/adapters/CreateClanColorAdapter;", "mainMenuItemsAdapter", "Lru/mrlargha/arizonaui/family/adapters/MainMenuAdapter;", "settingsAdapter", "Lru/mrlargha/arizonaui/family/adapters/SettingsAdapter;", "estateAdapter", "Lru/mrlargha/arizonaui/family/adapters/EstateAdapter;", "charterAdapter", "Lru/mrlargha/arizonaui/family/adapters/CharterAdapter;", "warAdapter", "Lru/mrlargha/arizonaui/family/adapters/WarsAdapter;", "membersAdapter", "Lru/mrlargha/arizonaui/family/adapters/MembersAdapter;", "charterMembersAdapter", "Lru/mrlargha/arizonaui/family/adapters/CharterMembersAdapter;", "ratingAdapter", "Lru/mrlargha/arizonaui/family/adapters/RatingAdapter;", "territoryAdapter", "Lru/mrlargha/arizonaui/family/adapters/TerritoryAdapter;", "meetingsAdapter", "Lru/mrlargha/arizonaui/family/adapters/MeetingsAdapter;", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/arizonaui/family/FamilyApi;", "setVisible", "", "visible", "onBackendMessage", "data", "subId", "initRetrofit", "setCreateInfo", "info", "setWarInfo", "Lru/mrlargha/arizonaui/family/data/FamilyWarData;", "setCharterInfo", "Lru/mrlargha/arizonaui/family/data/FamilyCharterData;", "setSettingsInfo", "Lru/mrlargha/arizonaui/family/data/FamilySettingsData;", "setEstateInfo", "Lru/mrlargha/arizonaui/family/data/FamilyEstateData;", "setMainMenu", "", "setFamilyInfo", "setupAdapters", "clearAdapters", "setupNavigation", "requestMembers", "page", "requestMembersName", "name", "requestCharterMembers", "requestCharterMembersName", "requestRating", "requestTerritories", "requestTopTerritories", "requestMeetings", "loadMapRetrofit", "loadMembersCount", "setUniqCells", "Lru/mrlargha/arizonaui/family/data/UniqCellItem;", "setMap", "setFrameMap", "Lru/mrlargha/arizonaui/family/data/FrameMapData;", "setFrameCharter", "item", "Lru/mrlargha/arizonaui/family/data/CharterItem;", "setFrameMember", "id", "onClickMembersFrame", "setupCreateClanPage", "checkCreateBntState", "selectMenuItem", "selectSettingsItem", "selectEstateItem", "selectCharterItem", "selectWarItem", "selectMemberItem", "Lru/mrlargha/arizonaui/family/data/MemberItem;", "selectCharterMemberItem", "selectRatingItem", "selectTerritoryItem", "setupSort", "sortTerritory1", "sortTerritory2", "sortTerritory3", "sortcharter1state", "sortcharter1", "sortcharter2state", "sortcharter2", "sortcharter3state", "sortcharter3", "sortcharter4state", "sortcharter4", "sortMeetings1state", "sortMeetings1", "sortMeetings2state", "sortMeetings2", "sortMeetings3state", "sortMeetings3", "sortMembers1state", "sortMembers1", "sortMembers2state", "sortMembers2", "navigateTo", "nav", "Lru/mrlargha/arizonaui/family/FamilyScreen$Navigation;", "Navigation", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyScreen extends SAMPUIElement implements InterfaceController {
    private final String _token;
    private FamilyApi api;
    private final FamilyMainBinding binding;
    private final CharterAdapter charterAdapter;
    private final CharterMembersAdapter charterMembersAdapter;
    private final CreateClanColorAdapter colorsAdapter;
    private FamilyCreateData createInfo;
    private boolean createIsSloganDone;
    private boolean createIsTitleDone;
    private int createSelectedImage;
    private final int createSelectedImageMax;
    private final EstateAdapter estateAdapter;
    private FamilyData familyData;
    private final CoroutineExceptionHandler handler;
    private final MainMenuAdapter mainMenuItemsAdapter;
    private final int mapCells;
    private final MeetingsAdapter meetingsAdapter;
    private final MembersAdapter membersAdapter;
    private final RatingAdapter ratingAdapter;
    private Retrofit retrofit;
    private final CoroutineScope scope;
    private final View screen;
    private final int serverId;
    private final SettingsAdapter settingsAdapter;
    private final SharedPreferences sharedPref;
    private boolean sortMeetings1state;
    private boolean sortMeetings2state;
    private boolean sortMeetings3state;
    private boolean sortMembers1state;
    private boolean sortMembers2state;
    private boolean sortcharter1state;
    private boolean sortcharter2state;
    private boolean sortcharter3state;
    private boolean sortcharter4state;
    private final TerritoryAdapter territoryAdapter;
    private final WarsAdapter warAdapter;
    private float xMargin;
    private float yMargin;

    /* compiled from: FamilyScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Navigation.values().length];
            try {
                iArr[Navigation.Create.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Navigation.Menu.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Navigation.Settings.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Navigation.Estate.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Navigation.Charter.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Navigation.War.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Navigation.Home.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Navigation.Members.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Navigation.CharterMembers.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Navigation.Rating.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Navigation.Map.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[Navigation.Territories.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[Navigation.Meetings.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$101$lambda$100(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$103$lambda$102(View view) {
    }

    private final void selectRatingItem() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$20(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.family_main, (ViewGroup) null);
        this.screen = screen;
        FamilyMainBinding bind = FamilyMainBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        FamilyScreen$special$$inlined$CoroutineExceptionHandler$1 familyScreen$special$$inlined$CoroutineExceptionHandler$1 = new FamilyScreen$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, targetActivity, i);
        this.handler = familyScreen$special$$inlined$CoroutineExceptionHandler$1;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob((Job) null)).plus(familyScreen$special$$inlined$CoroutineExceptionHandler$1));
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.serverId = sharedPreferences.getInt("server_id", 0);
        this._token = sharedPreferences.getString("api_token", "");
        this.createSelectedImageMax = 35;
        this.mapCells = 12;
        this.xMargin = 287.0f;
        this.yMargin = 250.0f;
        this.colorsAdapter = new CreateClanColorAdapter();
        this.mainMenuItemsAdapter = new MainMenuAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mainMenuItemsAdapter$lambda$1;
                mainMenuItemsAdapter$lambda$1 = FamilyScreen.mainMenuItemsAdapter$lambda$1(FamilyScreen.this, ((Integer) obj).intValue());
                return mainMenuItemsAdapter$lambda$1;
            }
        });
        this.settingsAdapter = new SettingsAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = FamilyScreen.settingsAdapter$lambda$2(FamilyScreen.this, ((Integer) obj).intValue());
                return unit;
            }
        });
        this.estateAdapter = new EstateAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit estateAdapter$lambda$3;
                estateAdapter$lambda$3 = FamilyScreen.estateAdapter$lambda$3(FamilyScreen.this, ((Integer) obj).intValue());
                return estateAdapter$lambda$3;
            }
        });
        this.charterAdapter = new CharterAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit charterAdapter$lambda$4;
                charterAdapter$lambda$4 = FamilyScreen.charterAdapter$lambda$4(FamilyScreen.this, ((Integer) obj).intValue());
                return charterAdapter$lambda$4;
            }
        });
        this.warAdapter = new WarsAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warAdapter$lambda$5;
                warAdapter$lambda$5 = FamilyScreen.warAdapter$lambda$5(FamilyScreen.this, ((Integer) obj).intValue());
                return warAdapter$lambda$5;
            }
        });
        this.membersAdapter = new MembersAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit membersAdapter$lambda$6;
                membersAdapter$lambda$6 = FamilyScreen.membersAdapter$lambda$6(FamilyScreen.this, (MemberItem) obj);
                return membersAdapter$lambda$6;
            }
        }, new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit membersAdapter$lambda$7;
                membersAdapter$lambda$7 = FamilyScreen.membersAdapter$lambda$7(FamilyScreen.this, ((Integer) obj).intValue());
                return membersAdapter$lambda$7;
            }
        });
        this.charterMembersAdapter = new CharterMembersAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit charterMembersAdapter$lambda$8;
                charterMembersAdapter$lambda$8 = FamilyScreen.charterMembersAdapter$lambda$8(FamilyScreen.this, (CharterItem) obj);
                return charterMembersAdapter$lambda$8;
            }
        }, new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit charterMembersAdapter$lambda$9;
                charterMembersAdapter$lambda$9 = FamilyScreen.charterMembersAdapter$lambda$9(FamilyScreen.this, ((Integer) obj).intValue());
                return charterMembersAdapter$lambda$9;
            }
        });
        this.ratingAdapter = new RatingAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ratingAdapter$lambda$10;
                ratingAdapter$lambda$10 = FamilyScreen.ratingAdapter$lambda$10(FamilyScreen.this, (RatingItem) obj);
                return ratingAdapter$lambda$10;
            }
        }, new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ratingAdapter$lambda$11;
                ratingAdapter$lambda$11 = FamilyScreen.ratingAdapter$lambda$11(FamilyScreen.this, ((Integer) obj).intValue());
                return ratingAdapter$lambda$11;
            }
        });
        this.territoryAdapter = new TerritoryAdapter(new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit territoryAdapter$lambda$12;
                territoryAdapter$lambda$12 = FamilyScreen.territoryAdapter$lambda$12(FamilyScreen.this, (FrameMapData) obj);
                return territoryAdapter$lambda$12;
            }
        }, new Function1() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit territoryAdapter$lambda$13;
                territoryAdapter$lambda$13 = FamilyScreen.territoryAdapter$lambda$13(FamilyScreen.this, (GangZoneItem) obj);
                return territoryAdapter$lambda$13;
            }
        });
        this.meetingsAdapter = new MeetingsAdapter();
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupNavigation();
        setupCreateClanPage();
        setupAdapters();
        setupSort();
        initRetrofit();
        this.sortcharter1state = true;
        this.sortcharter2state = true;
        this.sortcharter3state = true;
        this.sortcharter4state = true;
        this.sortMeetings1state = true;
        this.sortMeetings2state = true;
        this.sortMeetings3state = true;
        this.sortMembers1state = true;
        this.sortMembers2state = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getToken() {
        return "Bearer " + this._token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainMenuItemsAdapter$lambda$1(FamilyScreen familyScreen, int i) {
        familyScreen.selectMenuItem(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit settingsAdapter$lambda$2(FamilyScreen familyScreen, int i) {
        familyScreen.selectSettingsItem(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit estateAdapter$lambda$3(FamilyScreen familyScreen, int i) {
        familyScreen.selectEstateItem(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit charterAdapter$lambda$4(FamilyScreen familyScreen, int i) {
        familyScreen.selectCharterItem(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warAdapter$lambda$5(FamilyScreen familyScreen, int i) {
        familyScreen.selectWarItem(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit membersAdapter$lambda$6(FamilyScreen familyScreen, MemberItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        familyScreen.selectMemberItem(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit membersAdapter$lambda$7(FamilyScreen familyScreen, int i) {
        familyScreen.requestMembers(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit charterMembersAdapter$lambda$8(FamilyScreen familyScreen, CharterItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        familyScreen.selectCharterMemberItem(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit charterMembersAdapter$lambda$9(FamilyScreen familyScreen, int i) {
        familyScreen.requestCharterMembers(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ratingAdapter$lambda$10(FamilyScreen familyScreen, RatingItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        familyScreen.selectRatingItem();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ratingAdapter$lambda$11(FamilyScreen familyScreen, int i) {
        familyScreen.requestRating(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit territoryAdapter$lambda$12(FamilyScreen familyScreen, FrameMapData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        familyScreen.selectTerritoryItem(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit territoryAdapter$lambda$13(FamilyScreen familyScreen, GangZoneItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SAMPUIElement.notifyClick$default(familyScreen, 8, it.getId(), null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        clearAdapters();
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            switch (i) {
                case 0:
                    setMainMenu(MapperKt.toListModel(data, Integer.TYPE));
                    return;
                case 1:
                    setFamilyInfo((FamilyData) MapperKt.toModel(data, FamilyData.class));
                    return;
                case 2:
                    setSettingsInfo((FamilySettingsData) MapperKt.toModel(data, FamilySettingsData.class));
                    return;
                case 3:
                    setEstateInfo((FamilyEstateData) MapperKt.toModel(data, FamilyEstateData.class));
                    return;
                case 4:
                    setWarInfo((FamilyWarData) MapperKt.toModel(data, FamilyWarData.class));
                    return;
                case 5:
                    setCreateInfo((FamilyCreateData) MapperKt.toModel(data, FamilyCreateData.class));
                    return;
                case 6:
                    Integer intOrNull = StringsKt.toIntOrNull(data);
                    if ((intOrNull != null ? intOrNull.intValue() : 0) == 0) {
                        navigateTo(Navigation.Menu);
                        return;
                    } else {
                        navigateTo(Navigation.Create);
                        return;
                    }
                case 7:
                    setCharterInfo((FamilyCharterData) MapperKt.toModel(data, FamilyCharterData.class));
                    return;
                case 8:
                    setUniqCells(MapperKt.toListModel(data, UniqCellItem.class));
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            Log.d("FAMILY_ARIZONA", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    private final void initRetrofit() {
        Retrofit retrofit = null;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit build = new Retrofit.Builder().baseUrl(FirebaseConfigHelper.INSTANCE.getServerApiUrl() + "client/family/").client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.retrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        } else {
            retrofit = build;
        }
        Object create = retrofit.create(FamilyApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.api = (FamilyApi) create;
    }

    private final void setCreateInfo(FamilyCreateData familyCreateData) {
        this.createInfo = familyCreateData;
        FamilyCreateClanBinding familyCreateClanBinding = this.binding.create;
        familyCreateClanBinding.familyNameEdit.getText().clear();
        Drawable drawable = ContextCompat.getDrawable(getTargetActivity(), R.drawable.family_create_pen_ic);
        familyCreateClanBinding.familyNameEdit.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        familyCreateClanBinding.familyNameEdit.setBackgroundResource(R.drawable.family_create_edit_stroke);
        familyCreateClanBinding.titleHint.setText("Максимум 15 символов");
        familyCreateClanBinding.titleHint.setTextColor(Color.parseColor("#ABABAB"));
        familyCreateClanBinding.familySloganEdit.getText().clear();
        familyCreateClanBinding.familySloganEdit.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        familyCreateClanBinding.familySloganEdit.setBackgroundResource(R.drawable.family_create_edit_stroke);
        familyCreateClanBinding.sloganHint.setText("Максимум 40 символов");
        familyCreateClanBinding.sloganHint.setTextColor(Color.parseColor("#ABABAB"));
        this.createSelectedImage = 0;
        familyCreateClanBinding.logoImage.setImageResource(LogoKt.familyLogo(this.createSelectedImage));
        familyCreateClanBinding.logoNumber.setText((this.createSelectedImage + 1) + " / " + (this.createSelectedImageMax + 1));
        familyCreateClanBinding.logoTitle.setText(LogoKt.familyLogoTitles(this.createSelectedImage));
        this.colorsAdapter.clear();
        familyCreateClanBinding.loaderBar.setVisibility(8);
        familyCreateClanBinding.buttonCreateFamily.setCardBackgroundColor(Color.parseColor("#1AFFFFFF"));
        familyCreateClanBinding.buttonTitle.setVisibility(0);
        familyCreateClanBinding.createCost.setVisibility(0);
        if (familyCreateData.getMoney() >= familyCreateData.getPrice()) {
            familyCreateClanBinding.buttonTitle.setText("Создать семью");
        } else {
            familyCreateClanBinding.buttonTitle.setText("Необходимо иметь");
        }
        familyCreateClanBinding.buttonCreateFamily.setAlpha(0.5f);
        TextView textView = this.binding.create.createCost;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(familyCreateData.getPrice())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(StringsKt.replace$default(format, (char) AbstractJsonLexerKt.COMMA, ' ', false, 4, (Object) null) + " $");
        TextView textView2 = this.binding.topbar.createMoney;
        String format2 = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(familyCreateData.getMoney())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView2.setText(StringsKt.replace$default(format2, (char) AbstractJsonLexerKt.COMMA, ' ', false, 4, (Object) null) + " $");
    }

    private final void setWarInfo(FamilyWarData familyWarData) {
        this.warAdapter.setInfo(familyWarData);
    }

    private final void setCharterInfo(FamilyCharterData familyCharterData) {
        this.charterAdapter.setInfo(familyCharterData);
    }

    private final void setSettingsInfo(FamilySettingsData familySettingsData) {
        SettingsAdapter settingsAdapter = this.settingsAdapter;
        FamilyData familyData = this.familyData;
        settingsAdapter.setInfo(familyData != null ? familyData.getHasEstate() : 0, familySettingsData);
    }

    private final void setEstateInfo(FamilyEstateData familyEstateData) {
        EstateAdapter estateAdapter = this.estateAdapter;
        FamilyData familyData = this.familyData;
        estateAdapter.setInfo(familyEstateData, familyData != null ? familyData.getHasEstate() : 0);
    }

    private final void setMainMenu(List<Integer> list) {
        this.mainMenuItemsAdapter.setMenuItems(list);
    }

    private final void setFamilyInfo(FamilyData familyData) {
        String str;
        this.familyData = familyData;
        this.membersAdapter.setManager(familyData.getManagement() == 1);
        this.estateAdapter.setFlagTitle(familyData.getFlag());
        this.settingsAdapter.setAllianceTitle(familyData.getAliance());
        FamilyMainBinding familyMainBinding = this.binding;
        FamilyTopbarBinding familyTopbarBinding = familyMainBinding.topbar;
        familyTopbarBinding.familyTitle.setText(familyData.getTitle());
        familyTopbarBinding.familyType.setText(familyData.getType());
        familyTopbarBinding.logo.setImageResource(LogoKt.familyLogo(familyData.getIcon()));
        familyTopbarBinding.familyNotice.setText(familyData.getMessage());
        if (familyData.getMessage().length() == 0) {
            familyTopbarBinding.messageContainer.setVisibility(8);
        } else {
            familyTopbarBinding.messageContainer.setVisibility(0);
        }
        familyTopbarBinding.textRep.setText(familyData.getReputation() + " очк");
        Integer members = familyData.getMembers();
        if (members != null) {
            familyTopbarBinding.textDevil.setText(members.intValue() + " человек");
        }
        familyTopbarBinding.textMoney.setText("$ " + familyData.getMoney());
        familyTopbarBinding.textCoins.setText(familyData.getCoins() + " шт");
        if (familyData.getBg() == -1) {
            familyTopbarBinding.flag.setImageBitmap(null);
        } else {
            Bitmap decodeResource = BitmapFactory.decodeResource(getTargetActivity().getResources(), FlagsKt.familyFlag(familyData.getBg()));
            Intrinsics.checkNotNull(decodeResource);
            familyTopbarBinding.flag.setImageBitmap(UtilsKt.applyGradientMask(decodeResource));
        }
        FamilyHomePageBinding familyHomePageBinding = familyMainBinding.home;
        familyHomePageBinding.textPercent.setText(familyData.getDeposit() + " %");
        familyHomePageBinding.textPayday.setText(familyData.getPayDay() + " реп.");
        familyHomePageBinding.textLevel.setText(familyData.getLevel() + " уровень");
        familyHomePageBinding.textExperience.setText("Опыт: " + familyData.getCurrentExp() + " / " + familyData.getTotalExp() + " ");
        if (familyData.getTotalExp() > 0) {
            familyHomePageBinding.expProgressBar.setProgress((familyData.getCurrentExp() * 100) / familyData.getTotalExp());
            familyHomePageBinding.expProgressBar.setMax(100);
        }
        TextView textView = familyHomePageBinding.textFlag;
        if (familyData.getFlag().length() != 0) {
            str = familyData.getFlag().toString();
        }
        textView.setText(str);
        if (familyData.getBg() != -1) {
            familyHomePageBinding.idCard.setVisibility(0);
            familyHomePageBinding.idText.setText("ID: " + familyData.getBg());
            familyHomePageBinding.card1.setAlpha(1.0f);
        } else {
            familyHomePageBinding.idCard.setVisibility(8);
            familyHomePageBinding.card1.setAlpha(0.2f);
        }
        familyHomePageBinding.textAlliance.setText(familyData.getAliance());
        if (familyData.getFraction().length() == 0) {
            familyHomePageBinding.charterCard.setAlpha(0.2f);
            familyHomePageBinding.textCharter.setText("Отсутствует");
        } else {
            familyHomePageBinding.charterCard.setAlpha(1.0f);
            familyHomePageBinding.textCharter.setText(familyData.getFraction());
        }
        if (familyData.getVerification() == 1) {
            familyHomePageBinding.cardOfficial.setCardBackgroundColor(Color.parseColor("#1CC1FF3D"));
            familyHomePageBinding.cardOfficialText.setText("Приобретена");
            familyHomePageBinding.cardOfficialText.setTextColor(Color.parseColor("#C1FF3D"));
        } else {
            familyHomePageBinding.cardOfficial.setCardBackgroundColor(Color.parseColor("#32ABABAB"));
            familyHomePageBinding.cardOfficialText.setText("Отсутствует");
            familyHomePageBinding.cardOfficialText.setTextColor(Color.parseColor("#ABABAB"));
        }
        if (familyData.getBrand() == 1) {
            familyHomePageBinding.cardBrend.setCardBackgroundColor(Color.parseColor("#1CC1FF3D"));
            familyHomePageBinding.cardBrendText.setText("Приобретен");
            familyHomePageBinding.cardBrendText.setTextColor(Color.parseColor("#C1FF3D"));
        } else {
            familyHomePageBinding.cardBrend.setCardBackgroundColor(Color.parseColor("#32ABABAB"));
            familyHomePageBinding.cardBrendText.setText("Отсутствует");
            familyHomePageBinding.cardBrendText.setTextColor(Color.parseColor("#ABABAB"));
        }
        familyHomePageBinding.textDisc.setText(StringsKt.substringAfterLast$default(familyData.getDiscord(), '/', (String) null, 2, (Object) null));
        if (familyData.getDiscord().length() == 0) {
            familyHomePageBinding.discCard.setAlpha(0.2f);
            familyHomePageBinding.discDesc.setText("Отсутствует");
            familyHomePageBinding.buttonCopyDisc.setVisibility(8);
        } else {
            familyHomePageBinding.discCard.setAlpha(1.0f);
            familyHomePageBinding.discDesc.setText("Копировать ссылку");
            familyHomePageBinding.buttonCopyDisc.setVisibility(0);
        }
        int hasEstate = familyData.getHasEstate();
        if (hasEstate == 0) {
            familyHomePageBinding.apartTitle.setText("Осутствует");
            familyHomePageBinding.cardApart.setAlpha(0.2f);
        } else if (hasEstate == 1) {
            familyHomePageBinding.apartTitle.setText("Семейная квартира");
            familyHomePageBinding.imageApart.setImageResource(R.drawable.family_menu_ic_apart2);
            familyHomePageBinding.cardApart.setAlpha(1.0f);
        } else if (hasEstate == 2) {
            familyHomePageBinding.apartTitle.setText("Семейное поместье");
            familyHomePageBinding.imageApart.setImageResource(R.drawable.family_menu_ic_estate2);
            familyHomePageBinding.cardApart.setAlpha(1.0f);
        }
        Leader leader = (Leader) CollectionsKt.getOrNull(familyData.getLeaders(), 0);
        if (leader == null) {
            leader = new Leader("Отсутствует", -1, " ");
        }
        familyHomePageBinding.textLeader1.setText(leader.getName());
        if (leader.getOnline() == 1) {
            familyHomePageBinding.onlineLeader1.setVisibility(0);
        } else {
            familyHomePageBinding.onlineLeader1.setVisibility(8);
        }
        if (leader.getOnline() == -1) {
            familyHomePageBinding.leader1.setAlpha(0.2f);
        } else {
            familyHomePageBinding.leader1.setAlpha(1.0f);
        }
        Leader leader2 = (Leader) CollectionsKt.getOrNull(familyData.getLeaders(), 1);
        if (leader2 == null) {
            leader2 = new Leader("Отсутствует", -1, " ");
        }
        familyHomePageBinding.textLeader2.setText(leader2.getName());
        if (leader2.getOnline() == 1) {
            familyHomePageBinding.onlineLeader2.setVisibility(0);
        } else {
            familyHomePageBinding.onlineLeader2.setVisibility(8);
        }
        if (leader2.getOnline() == -1) {
            familyHomePageBinding.leader2.setAlpha(0.2f);
        } else {
            familyHomePageBinding.leader2.setAlpha(1.0f);
        }
        Leader leader3 = (Leader) CollectionsKt.getOrNull(familyData.getLeaders(), 2);
        if (leader3 == null) {
            leader3 = new Leader("Отсутствует", -1, " ");
        }
        familyHomePageBinding.textLeader3.setText(leader3.getName());
        if (leader3.getOnline() == 1) {
            familyHomePageBinding.onlineLeader3.setVisibility(0);
        } else {
            familyHomePageBinding.onlineLeader3.setVisibility(8);
        }
        if (leader3.getOnline() == -1) {
            familyHomePageBinding.leader3.setAlpha(0.2f);
        } else {
            familyHomePageBinding.leader3.setAlpha(1.0f);
        }
        Leader leader4 = (Leader) CollectionsKt.getOrNull(familyData.getLeaders(), 3);
        if (leader4 == null) {
            leader4 = new Leader("Отсутствует", -1, " ");
        }
        familyHomePageBinding.textLeader4.setText(leader4.getName());
        if (leader4.getOnline() == 1) {
            familyHomePageBinding.onlineLeader4.setVisibility(0);
        } else {
            familyHomePageBinding.onlineLeader4.setVisibility(8);
        }
        if (leader4.getOnline() == -1) {
            familyHomePageBinding.leader4.setAlpha(0.2f);
        } else {
            familyHomePageBinding.leader4.setAlpha(1.0f);
        }
        familyHomePageBinding.textApartName.setText(familyData.getApart());
        this.mainMenuItemsAdapter.setOnline(familyData.getOnline());
    }

    private final void setupAdapters() {
        FamilyMainBinding familyMainBinding = this.binding;
        familyMainBinding.create.colorsRv.setAdapter(this.colorsAdapter);
        familyMainBinding.menu.menuItemsRv.setAdapter(this.mainMenuItemsAdapter);
        familyMainBinding.settings.menuItemsRv.setAdapter(this.settingsAdapter);
        familyMainBinding.estate.menuItemsRv.setAdapter(this.estateAdapter);
        familyMainBinding.charter.menuItemsRv.setAdapter(this.charterAdapter);
        familyMainBinding.war.menuItemsRv.setAdapter(this.warAdapter);
        familyMainBinding.members.taskRecycleView.setAdapter(this.membersAdapter);
        familyMainBinding.rating.taskRecycleView.setAdapter(this.ratingAdapter);
        familyMainBinding.charterMembers.taskRecycleView.setAdapter(this.charterMembersAdapter);
        familyMainBinding.territories.taskRecycleView.setAdapter(this.territoryAdapter);
        familyMainBinding.meetings.taskRecycleView.setAdapter(this.meetingsAdapter);
    }

    private final void clearAdapters() {
        this.membersAdapter.clearList();
        this.ratingAdapter.clearList();
        this.charterMembersAdapter.clearList();
    }

    private final void setupNavigation() {
        this.binding.familyOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$20(view);
            }
        });
        FamilyHomePageBinding familyHomePageBinding = this.binding.home;
        familyHomePageBinding.buttonPayday.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$24$lambda$21(FamilyScreen.this, view);
            }
        });
        familyHomePageBinding.buttonAlliance.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$24$lambda$22(FamilyScreen.this, view);
            }
        });
        familyHomePageBinding.buttonCopyDisc.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$24$lambda$23(FamilyScreen.this, view);
            }
        });
        FamilyTopbarBinding familyTopbarBinding = this.binding.topbar;
        familyTopbarBinding.closeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$32$lambda$25(FamilyScreen.this, view);
            }
        });
        familyTopbarBinding.buttonRep.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$32$lambda$26(FamilyScreen.this, view);
            }
        });
        familyTopbarBinding.buttonMoney.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$32$lambda$27(FamilyScreen.this, view);
            }
        });
        familyTopbarBinding.buttonCoins.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$32$lambda$28(FamilyScreen.this, view);
            }
        });
        familyTopbarBinding.inviteBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$32$lambda$29(FamilyScreen.this, view);
            }
        });
        familyTopbarBinding.kickBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$32$lambda$30(FamilyScreen.this, view);
            }
        });
        familyTopbarBinding.ratingBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$32$lambda$31(FamilyScreen.this, view);
            }
        });
        FamilyMainBinding familyMainBinding = this.binding;
        familyMainBinding.frameMap.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$36$lambda$33(FamilyScreen.this, view);
            }
        });
        familyMainBinding.frameMember.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$36$lambda$34(FamilyScreen.this, view);
            }
        });
        familyMainBinding.frameCharter.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupNavigation$lambda$36$lambda$35(FamilyScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$24$lambda$21(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 1, 4, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$24$lambda$22(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 1, 5, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$24$lambda$23(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 1, 6, null, 4, null);
        Object systemService = familyScreen.getTargetActivity().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        FamilyData familyData = familyScreen.familyData;
        clipboardManager.setPrimaryClip(ClipData.newPlainText(r0, (familyData == null || (r6 = familyData.getDiscord()) == null) ? "" : ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$32$lambda$25(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 9, 0, null, 4, null);
        familyScreen.getNotifier().setUIElementVisible(familyScreen.getBackendID(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$32$lambda$26(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 1, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$32$lambda$27(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 1, 2, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$32$lambda$28(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 1, 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$32$lambda$29(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 2, 18, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$32$lambda$30(FamilyScreen familyScreen, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 2, 19, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$32$lambda$31(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Rating);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$36$lambda$33(FamilyScreen familyScreen, View view) {
        familyScreen.binding.frameMap.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$36$lambda$34(FamilyScreen familyScreen, View view) {
        familyScreen.binding.frameMember.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$36$lambda$35(FamilyScreen familyScreen, View view) {
        familyScreen.binding.frameCharter.getRoot().setVisibility(8);
    }

    private final void requestMembers(int i) {
        FamilyData familyData = this.familyData;
        if (familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestMembers$1$1(this, familyData, i, null), 3, null);
        }
    }

    private final void requestMembersName(String str) {
        FamilyData familyData = this.familyData;
        if (familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestMembersName$1$1(this, familyData, str, null), 3, null);
        }
    }

    private final void requestCharterMembers(int i) {
        FamilyData familyData = this.familyData;
        if (familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestCharterMembers$1$1(this, familyData, i, null), 3, null);
        }
    }

    private final void requestCharterMembersName(String str) {
        FamilyData familyData = this.familyData;
        if (familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestCharterMembersName$1$1(this, familyData, str, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestRating(int i) {
        if (this.familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestRating$1$1(this, i, null), 3, null);
        }
    }

    private final void requestTerritories() {
        if (this.familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestTerritories$1$1(this, null), 3, null);
        }
    }

    private final void requestTopTerritories() {
        if (this.familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestTopTerritories$1$1(this, null), 3, null);
        }
    }

    private final void requestMeetings() {
        if (this.familyData != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$requestMeetings$1$1(this, null), 3, null);
        }
    }

    private final void loadMapRetrofit() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$loadMapRetrofit$1(this, null), 3, null);
    }

    private final void loadMembersCount() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$loadMembersCount$1(this, null), 3, null);
    }

    private final void setUniqCells(List<UniqCellItem> list) {
        this.territoryAdapter.addUniq(list);
        GridOverlayView.setDataAndTryToDraw$default(this.binding.map.overlayView, null, list, 1, null);
    }

    private final void setMap() {
        loadMapRetrofit();
        Bitmap decodeStream = BitmapFactory.decodeStream(getTargetActivity().getResources().openRawResource(R.raw.map_arizona));
        final SubsamplingScaleImageView subsamplingScaleImageView = this.binding.map.mapView;
        subsamplingScaleImageView.setImage(ImageSource.bitmap(decodeStream));
        float f = 300;
        subsamplingScaleImageView.setScaleAndCenter(2.0f, new PointF(this.xMargin + f, this.yMargin + f));
        subsamplingScaleImageView.setMaxScale(10.0f);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final int scaledTouchSlop = ViewConfiguration.get(subsamplingScaleImageView.getContext()).getScaledTouchSlop();
        subsamplingScaleImageView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda55
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean map$lambda$48$lambda$47;
                map$lambda$48$lambda$47 = FamilyScreen.setMap$lambda$48$lambda$47(Ref.FloatRef.this, floatRef2, scaledTouchSlop, subsamplingScaleImageView, this, view, motionEvent);
                return map$lambda$48$lambda$47;
            }
        });
        GridOverlayView gridOverlayView = this.binding.map.overlayView;
        SubsamplingScaleImageView mapView = this.binding.map.mapView;
        Intrinsics.checkNotNullExpressionValue(mapView, "mapView");
        gridOverlayView.setLinkedImageView(mapView, this.mapCells, this.xMargin, this.yMargin);
        this.binding.map.mapView.setOnStateChangedListener(new SubsamplingScaleImageView.OnStateChangedListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$setMap$2
            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
            public void onScaleChanged(float f2, int i) {
                FamilyMainBinding familyMainBinding;
                familyMainBinding = FamilyScreen.this.binding;
                familyMainBinding.map.overlayView.invalidate();
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
            public void onCenterChanged(PointF newCenter, int i) {
                FamilyMainBinding familyMainBinding;
                Intrinsics.checkNotNullParameter(newCenter, "newCenter");
                familyMainBinding = FamilyScreen.this.binding;
                familyMainBinding.map.overlayView.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setMap$lambda$48$lambda$47(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, int i, SubsamplingScaleImageView subsamplingScaleImageView, FamilyScreen familyScreen, View view, MotionEvent motionEvent) {
        PointF viewToSourceCoord;
        Object obj;
        Object obj2;
        int action = motionEvent.getAction();
        if (action == 0) {
            floatRef.element = motionEvent.getX();
            floatRef2.element = motionEvent.getY();
            return false;
        } else if (action != 1) {
            return false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f = x - floatRef.element;
            float f2 = y - floatRef2.element;
            if ((f * f) + (f2 * f2) >= i * i || (viewToSourceCoord = subsamplingScaleImageView.viewToSourceCoord(x, y)) == null) {
                return false;
            }
            int i2 = (int) ((viewToSourceCoord.x - familyScreen.xMargin) / 85.0f);
            int i3 = (int) ((viewToSourceCoord.y - familyScreen.yMargin) / 85.0f);
            if (i3 >= 0) {
                int i4 = familyScreen.mapCells;
                if (i3 >= i4 + 1 || i2 < 0 || i2 >= i4) {
                    return false;
                }
                int i5 = (i3 * i4) + i2 + 1;
                Iterator<T> it = familyScreen.binding.map.overlayView.get_mapData().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((GangZoneItem) obj).getId() == i5) {
                        break;
                    }
                }
                GangZoneItem gangZoneItem = (GangZoneItem) obj;
                String family_name = gangZoneItem != null ? gangZoneItem.getFamily_name() : null;
                Integer valueOf = gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_flag()) : null;
                Integer valueOf2 = gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_logo()) : null;
                Integer valueOf3 = gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_money()) : null;
                Integer valueOf4 = gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_moneta()) : null;
                Iterator<T> it2 = familyScreen.binding.map.overlayView.get_uniqueData().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    if (((UniqCellItem) obj2).getId() == i5) {
                        break;
                    }
                }
                UniqCellItem uniqCellItem = (UniqCellItem) obj2;
                familyScreen.setFrameMap(new FrameMapData(i5, family_name, valueOf, valueOf2, valueOf3, valueOf4, uniqCellItem != null ? uniqCellItem.getName() : null));
                return false;
            }
            return false;
        }
    }

    private final void setFrameMap(final FrameMapData frameMapData) {
        FamilyMapFrameBinding familyMapFrameBinding = this.binding.frameMap;
        familyMapFrameBinding.getRoot().setVisibility(0);
        familyMapFrameBinding.title.setText("Территория №" + frameMapData.getId());
        if (frameMapData.getOwner() == null) {
            familyMapFrameBinding.famName.setText("Свободная территория");
            familyMapFrameBinding.logo.setVisibility(8);
            familyMapFrameBinding.flag.setVisibility(8);
        } else {
            familyMapFrameBinding.famName.setText(frameMapData.getOwner());
            Integer logo = frameMapData.getLogo();
            if (logo != null) {
                logo.intValue();
                familyMapFrameBinding.logo.setVisibility(0);
                familyMapFrameBinding.logo.setImageResource(LogoKt.familyLogo(frameMapData.getLogo().intValue()));
            }
            Integer flag = frameMapData.getFlag();
            if (flag != null && flag.intValue() >= 0) {
                familyMapFrameBinding.flag.setVisibility(0);
                familyMapFrameBinding.flag.setImageResource(FlagsKt.familyFlag(frameMapData.getFlag().intValue()));
            }
        }
        if (frameMapData.getBalance() == null) {
            familyMapFrameBinding.containerBalance.setVisibility(8);
        } else {
            familyMapFrameBinding.containerBalance.setVisibility(0);
            familyMapFrameBinding.balance.setText(frameMapData.getBalance() + " $");
        }
        if (frameMapData.getCoins() == null) {
            familyMapFrameBinding.containerCoins.setVisibility(8);
        } else {
            familyMapFrameBinding.containerCoins.setVisibility(0);
            familyMapFrameBinding.coins.setText(String.valueOf(frameMapData.getCoins()));
        }
        if (frameMapData.getUniq() == null) {
            familyMapFrameBinding.containerBusiness.setVisibility(8);
        } else {
            familyMapFrameBinding.containerBusiness.setVisibility(0);
            familyMapFrameBinding.businessTitle.setText(frameMapData.getUniq());
        }
        familyMapFrameBinding.buttonEvent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setFrameMap$lambda$52$lambda$51(FamilyScreen.this, frameMapData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameMap$lambda$52$lambda$51(FamilyScreen familyScreen, FrameMapData frameMapData, View view) {
        SAMPUIElement.notifyClick$default(familyScreen, 7, frameMapData.getId(), null, 4, null);
    }

    private final void setFrameCharter(CharterItem charterItem) {
        int i;
        FamilyCharterFrameBinding familyCharterFrameBinding = this.binding.frameCharter;
        familyCharterFrameBinding.getRoot().setVisibility(0);
        familyCharterFrameBinding.memberName.setText(charterItem.getName());
        if (charterItem.getOnline() == 1001) {
            i = R.drawable.family_offline_ic;
        } else {
            i = R.drawable.family_online_ic;
        }
        familyCharterFrameBinding.onlineImage.setImageResource(i);
        familyCharterFrameBinding.rank.setText(String.valueOf(charterItem.getFractionRank()));
        familyCharterFrameBinding.times.setText(charterItem.getFractionDays() + " д.");
        familyCharterFrameBinding.days.setText(charterItem.getPaidDays() + " д.");
        familyCharterFrameBinding.activeWeek.setText(charterItem.getWeeklyActive() + " ч.");
        familyCharterFrameBinding.memberRole.setVisibility(0);
        if (charterItem.isLeader()) {
            familyCharterFrameBinding.memberRole.setText("Лидер");
        } else if (charterItem.isDeputy()) {
            familyCharterFrameBinding.memberRole.setText("Заместитель");
        } else {
            familyCharterFrameBinding.memberRole.setVisibility(8);
        }
    }

    private final void setFrameMember(final int i, final String str) {
        final FamilyMembersFrameBinding familyMembersFrameBinding = this.binding.frameMember;
        familyMembersFrameBinding.getRoot().setVisibility(0);
        familyMembersFrameBinding.buttonPrem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setFrameMember$lambda$58$lambda$54(FamilyMembersFrameBinding.this, this, i, str, view);
            }
        });
        familyMembersFrameBinding.buttonRank.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setFrameMember$lambda$58$lambda$55(FamilyMembersFrameBinding.this, this, i, str, view);
            }
        });
        familyMembersFrameBinding.buttonWarn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setFrameMember$lambda$58$lambda$56(FamilyMembersFrameBinding.this, this, i, str, view);
            }
        });
        familyMembersFrameBinding.buttonKick.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setFrameMember$lambda$58$lambda$57(FamilyMembersFrameBinding.this, this, i, str, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameMember$lambda$58$lambda$54(FamilyMembersFrameBinding familyMembersFrameBinding, FamilyScreen familyScreen, int i, String str, View view) {
        familyMembersFrameBinding.buttonPrem.setCardBackgroundColor(-1);
        familyMembersFrameBinding.buttonPremText.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        familyScreen.notifyClick(10, 0, "{\"id\":" + i + ", \"name\":\"" + str + "\" }");
        familyScreen.onClickMembersFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameMember$lambda$58$lambda$55(FamilyMembersFrameBinding familyMembersFrameBinding, FamilyScreen familyScreen, int i, String str, View view) {
        familyMembersFrameBinding.buttonRank.setCardBackgroundColor(-1);
        familyMembersFrameBinding.buttonRankText.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        familyScreen.notifyClick(10, 1, "{\"id\":" + i + ", \"name\":\"" + str + "\" }");
        familyScreen.onClickMembersFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameMember$lambda$58$lambda$56(FamilyMembersFrameBinding familyMembersFrameBinding, FamilyScreen familyScreen, int i, String str, View view) {
        familyMembersFrameBinding.buttonWarn.setCardBackgroundColor(-1);
        familyMembersFrameBinding.buttonWarnText.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        familyScreen.notifyClick(10, 2, "{\"id\":" + i + ", \"name\":\"" + str + "\" }");
        familyScreen.onClickMembersFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFrameMember$lambda$58$lambda$57(FamilyMembersFrameBinding familyMembersFrameBinding, FamilyScreen familyScreen, int i, String str, View view) {
        familyMembersFrameBinding.buttonKick.setCardBackgroundColor(-1);
        familyMembersFrameBinding.buttonKickText.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        familyScreen.notifyClick(10, 3, "{\"id\":" + i + ", \"name\":\"" + str + "\" }");
        familyScreen.onClickMembersFrame();
    }

    private final void onClickMembersFrame() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FamilyScreen$onClickMembersFrame$1(this, null), 3, null);
    }

    private final void setupCreateClanPage() {
        final FamilyCreateClanBinding familyCreateClanBinding = this.binding.create;
        familyCreateClanBinding.logoLeftArrow.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda66
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupCreateClanPage$lambda$68$lambda$59(FamilyScreen.this, familyCreateClanBinding, view);
            }
        });
        familyCreateClanBinding.logoRightArrow.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda69
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupCreateClanPage$lambda$68$lambda$60(FamilyScreen.this, familyCreateClanBinding, view);
            }
        });
        familyCreateClanBinding.colorLeftArrow.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupCreateClanPage$lambda$68$lambda$61(FamilyCreateClanBinding.this, view);
            }
        });
        familyCreateClanBinding.colorRightArrow.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda71
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.setupCreateClanPage$lambda$68$lambda$62(FamilyCreateClanBinding.this, view);
            }
        });
        familyCreateClanBinding.familyNameEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z;
                z = FamilyScreen.setupCreateClanPage$lambda$68$lambda$63(textView, i, keyEvent);
                return z;
            }
        });
        familyCreateClanBinding.familySloganEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z;
                z = FamilyScreen.setupCreateClanPage$lambda$68$lambda$64(textView, i, keyEvent);
                return z;
            }
        });
        familyCreateClanBinding.familyNameEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                FamilyScreen.setupCreateClanPage$lambda$68$lambda$65(FamilyCreateClanBinding.this, this, view, z);
            }
        });
        familyCreateClanBinding.familySloganEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                FamilyScreen.setupCreateClanPage$lambda$68$lambda$67(FamilyCreateClanBinding.this, this, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateClanPage$lambda$68$lambda$59(FamilyScreen familyScreen, FamilyCreateClanBinding familyCreateClanBinding, View view) {
        int i = familyScreen.createSelectedImage;
        familyScreen.createSelectedImage = i <= 0 ? familyScreen.createSelectedImageMax : i - 1;
        familyCreateClanBinding.logoImage.setImageResource(LogoKt.familyLogo(familyScreen.createSelectedImage));
        familyCreateClanBinding.logoNumber.setText((familyScreen.createSelectedImage + 1) + " / " + (familyScreen.createSelectedImageMax + 1));
        familyCreateClanBinding.logoTitle.setText(LogoKt.familyLogoTitles(familyScreen.createSelectedImage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateClanPage$lambda$68$lambda$60(FamilyScreen familyScreen, FamilyCreateClanBinding familyCreateClanBinding, View view) {
        int i = familyScreen.createSelectedImage;
        familyScreen.createSelectedImage = i >= familyScreen.createSelectedImageMax ? 0 : i + 1;
        familyCreateClanBinding.logoImage.setImageResource(LogoKt.familyLogo(familyScreen.createSelectedImage));
        familyCreateClanBinding.logoTitle.setText(LogoKt.familyLogoTitles(familyScreen.createSelectedImage));
        familyCreateClanBinding.logoNumber.setText((familyScreen.createSelectedImage + 1) + " / " + (familyScreen.createSelectedImageMax + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateClanPage$lambda$68$lambda$61(FamilyCreateClanBinding familyCreateClanBinding, View view) {
        familyCreateClanBinding.colorsRv.smoothScrollBy(-100, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateClanPage$lambda$68$lambda$62(FamilyCreateClanBinding familyCreateClanBinding, View view) {
        familyCreateClanBinding.colorsRv.smoothScrollBy(100, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupCreateClanPage$lambda$68$lambda$63(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            textView.clearFocus();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupCreateClanPage$lambda$68$lambda$64(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            textView.clearFocus();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateClanPage$lambda$68$lambda$65(FamilyCreateClanBinding familyCreateClanBinding, FamilyScreen familyScreen, View view, boolean z) {
        if (z) {
            return;
        }
        String replace = new Regex("[^A-Za-zА-Яа-я]").replace(familyCreateClanBinding.familyNameEdit.getText().toString(), "");
        familyCreateClanBinding.familyNameEdit.setText(replace);
        familyCreateClanBinding.familyNameEdit.setSelection(replace.length());
        Editable text = familyCreateClanBinding.familyNameEdit.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() > 0 && familyCreateClanBinding.familyNameEdit.getText().length() >= 5) {
            familyCreateClanBinding.familyNameEdit.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(familyScreen.getTargetActivity(), R.drawable.family_create_done_ic), (Drawable) null);
            familyCreateClanBinding.familyNameEdit.setBackgroundResource(R.drawable.family_create_edit_stroke_done);
            familyCreateClanBinding.titleHint.setText("Это название доступно!");
            familyCreateClanBinding.titleHint.setTextColor(Color.parseColor("#C1FF3D"));
            familyScreen.createIsTitleDone = true;
        } else {
            familyCreateClanBinding.familyNameEdit.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(familyScreen.getTargetActivity(), R.drawable.family_create_pen_ic), (Drawable) null);
            familyCreateClanBinding.familyNameEdit.setBackgroundResource(R.drawable.family_create_edit_stroke_dont);
            familyCreateClanBinding.titleHint.setText("Минимум символов 5");
            familyCreateClanBinding.titleHint.setTextColor(Color.parseColor("#FE5B3B"));
            familyScreen.createIsTitleDone = false;
        }
        familyScreen.checkCreateBntState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateClanPage$lambda$68$lambda$67(final FamilyCreateClanBinding familyCreateClanBinding, FamilyScreen familyScreen, View view, boolean z) {
        familyCreateClanBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyScreen.setupCreateClanPage$lambda$68$lambda$67$lambda$66(FamilyCreateClanBinding.this, view2);
            }
        });
        if (z) {
            familyCreateClanBinding.titleHint.setVisibility(8);
            familyCreateClanBinding.nameTitle.setVisibility(8);
            familyCreateClanBinding.nameView.setVisibility(8);
            familyCreateClanBinding.familyNameEdit.setVisibility(8);
        }
        if (z) {
            return;
        }
        String replace = new Regex("[^A-Za-zА-Яа-я0-9 ]").replace(familyCreateClanBinding.familySloganEdit.getText().toString(), "");
        familyCreateClanBinding.familySloganEdit.setText(replace);
        familyCreateClanBinding.familySloganEdit.setSelection(replace.length());
        familyCreateClanBinding.titleHint.setVisibility(0);
        familyCreateClanBinding.nameTitle.setVisibility(0);
        familyCreateClanBinding.nameView.setVisibility(0);
        familyCreateClanBinding.familyNameEdit.setVisibility(0);
        Editable text = familyCreateClanBinding.familySloganEdit.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() > 0 && familyCreateClanBinding.familySloganEdit.getText().length() >= 15) {
            familyCreateClanBinding.familySloganEdit.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(familyScreen.getTargetActivity(), R.drawable.family_create_done_ic), (Drawable) null);
            familyCreateClanBinding.familySloganEdit.setBackgroundResource(R.drawable.family_create_edit_stroke_done);
            familyCreateClanBinding.sloganHint.setText("Слоган подходит!");
            familyCreateClanBinding.sloganHint.setTextColor(Color.parseColor("#C1FF3D"));
            familyScreen.createIsSloganDone = true;
        } else {
            familyCreateClanBinding.familySloganEdit.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(familyScreen.getTargetActivity(), R.drawable.family_create_pen_ic), (Drawable) null);
            familyCreateClanBinding.familySloganEdit.setBackgroundResource(R.drawable.family_create_edit_stroke_dont);
            familyCreateClanBinding.sloganHint.setText("Минимум символов 15");
            familyCreateClanBinding.sloganHint.setTextColor(Color.parseColor("#FE5B3B"));
            familyScreen.createIsSloganDone = false;
        }
        familyScreen.checkCreateBntState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateClanPage$lambda$68$lambda$67$lambda$66(FamilyCreateClanBinding familyCreateClanBinding, View view) {
        familyCreateClanBinding.familySloganEdit.clearFocus();
    }

    private final void checkCreateBntState() {
        FamilyCreateClanBinding familyCreateClanBinding = this.binding.create;
        FamilyCreateData familyCreateData = this.createInfo;
        int price = familyCreateData != null ? familyCreateData.getPrice() : 200000;
        FamilyCreateData familyCreateData2 = this.createInfo;
        if (price > (familyCreateData2 != null ? familyCreateData2.getMoney() : 0)) {
            familyCreateClanBinding.buttonCreateFamily.setCardBackgroundColor(Color.parseColor("#1AFFFFFF"));
            familyCreateClanBinding.createCost.setVisibility(0);
            familyCreateClanBinding.buttonTitle.setVisibility(0);
            familyCreateClanBinding.buttonTitle.setText("Необходимо иметь");
            familyCreateClanBinding.loaderBar.setVisibility(8);
            familyCreateClanBinding.buttonCreateFamily.setAlpha(0.5f);
        } else if (!this.createIsTitleDone || !this.createIsSloganDone) {
            familyCreateClanBinding.buttonCreateFamily.setCardBackgroundColor(Color.parseColor("#1AFFFFFF"));
            familyCreateClanBinding.createCost.setVisibility(0);
            familyCreateClanBinding.buttonTitle.setVisibility(0);
            familyCreateClanBinding.buttonTitle.setText("Создать семью");
            familyCreateClanBinding.buttonCreateFamily.setAlpha(0.5f);
        } else {
            familyCreateClanBinding.buttonCreateFamily.setCardBackgroundColor(Color.parseColor("#4DFFFFFF"));
            familyCreateClanBinding.createCost.setVisibility(0);
            familyCreateClanBinding.buttonTitle.setVisibility(0);
            familyCreateClanBinding.buttonTitle.setText("Создать семью");
            familyCreateClanBinding.loaderBar.setVisibility(8);
            familyCreateClanBinding.buttonCreateFamily.setAlpha(1.0f);
            familyCreateClanBinding.buttonCreateFamily.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda49
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FamilyScreen.checkCreateBntState$lambda$70$lambda$69(FamilyScreen.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkCreateBntState$lambda$70$lambda$69(FamilyScreen familyScreen, View view) {
        int i = familyScreen.createSelectedImage;
        int selectedColorPos = familyScreen.colorsAdapter.getSelectedColorPos();
        Editable text = familyScreen.binding.create.familyNameEdit.getText();
        familyScreen.notifyClick(3, 0, "{\"icon\": " + i + ",\"color_id\": " + selectedColorPos + ",\"name\": \"" + ((Object) text) + "\",\"slogan\": \"" + ((Object) familyScreen.binding.create.familySloganEdit.getText()) + "\"}");
    }

    private final void selectMenuItem(int i) {
        if (i == 0) {
            navigateTo(Navigation.Home);
        } else if (i == 1) {
            navigateTo(Navigation.Members);
        } else if (i == 2) {
            navigateTo(Navigation.War);
        } else if (i == 4) {
            navigateTo(Navigation.Settings);
        } else if (i == 5) {
            navigateTo(Navigation.Estate);
        } else if (i == 6) {
            navigateTo(Navigation.Estate);
        } else if (i == 7) {
            navigateTo(Navigation.Charter);
        }
        SAMPUIElement.notifyClick$default(this, 0, i, null, 4, null);
    }

    private final void selectSettingsItem(int i) {
        SAMPUIElement.notifyClick$default(this, 2, i, null, 4, null);
        if (i == 17) {
            navigateTo(Navigation.Estate);
        }
    }

    private final void selectEstateItem(int i) {
        SAMPUIElement.notifyClick$default(this, 4, i, null, 4, null);
    }

    private final void selectCharterItem(int i) {
        if (i == 4) {
            navigateTo(Navigation.CharterMembers);
        }
        if (i >= 4) {
            SAMPUIElement.notifyClick$default(this, 5, i - 4, null, 4, null);
        }
    }

    private final void selectWarItem(int i) {
        if (i == 4) {
            navigateTo(Navigation.Map);
        } else if (i == 6) {
            navigateTo(Navigation.Meetings);
        } else if (i == 7) {
            navigateTo(Navigation.Territories);
        }
        SAMPUIElement.notifyClick$default(this, 6, i - 4, null, 4, null);
    }

    private final void selectMemberItem(MemberItem memberItem) {
        setFrameMember(memberItem.getAccountId(), memberItem.getName());
    }

    private final void selectCharterMemberItem(CharterItem charterItem) {
        setFrameCharter(charterItem);
    }

    private final void selectTerritoryItem(FrameMapData frameMapData) {
        setFrameMap(frameMapData);
    }

    private final void setupSort() {
        FamilyTerritoriesBinding familyTerritoriesBinding = this.binding.territories;
        familyTerritoriesBinding.text1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortTerritory1();
            }
        });
        familyTerritoriesBinding.text2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortTerritory2();
            }
        });
        familyTerritoriesBinding.text3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortTerritory3();
            }
        });
        FamilyCharterMembersBinding familyCharterMembersBinding = this.binding.charterMembers;
        familyCharterMembersBinding.text1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortcharter1();
            }
        });
        familyCharterMembersBinding.text2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortcharter2();
            }
        });
        familyCharterMembersBinding.text3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortcharter3();
            }
        });
        familyCharterMembersBinding.text4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortcharter4();
            }
        });
        FamilyMembersBinding familyMembersBinding = this.binding.members;
        familyMembersBinding.text1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortMembers1();
            }
        });
        familyMembersBinding.text2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortMembers2();
            }
        });
        FamilyMeetingsBinding familyMeetingsBinding = this.binding.meetings;
        familyMeetingsBinding.text1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortMeetings1();
            }
        });
        familyMeetingsBinding.text2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortMeetings2();
            }
        });
        familyMeetingsBinding.text3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyScreen.this.sortMeetings3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortTerritory1() {
        FamilyTerritoriesBinding familyTerritoriesBinding = this.binding.territories;
        familyTerritoriesBinding.text1.setTextColor(Color.parseColor("#FFFFFF"));
        familyTerritoriesBinding.text2.setTextColor(Color.parseColor("#99FFFFFF"));
        familyTerritoriesBinding.text3.setTextColor(Color.parseColor("#99FFFFFF"));
        familyTerritoriesBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort);
        familyTerritoriesBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        familyTerritoriesBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        this.territoryAdapter.sort1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortTerritory2() {
        FamilyTerritoriesBinding familyTerritoriesBinding = this.binding.territories;
        familyTerritoriesBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyTerritoriesBinding.text2.setTextColor(Color.parseColor("#FFFFFF"));
        familyTerritoriesBinding.text3.setTextColor(Color.parseColor("#99FFFFFF"));
        familyTerritoriesBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyTerritoriesBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort);
        familyTerritoriesBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        this.territoryAdapter.sort2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortTerritory3() {
        FamilyTerritoriesBinding familyTerritoriesBinding = this.binding.territories;
        familyTerritoriesBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyTerritoriesBinding.text2.setTextColor(Color.parseColor("#99FFFFFF"));
        familyTerritoriesBinding.text3.setTextColor(Color.parseColor("#FFFFFF"));
        familyTerritoriesBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyTerritoriesBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        familyTerritoriesBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort);
        this.territoryAdapter.sort3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortcharter1() {
        FamilyCharterMembersBinding familyCharterMembersBinding = this.binding.charterMembers;
        familyCharterMembersBinding.text1.setTextColor(Color.parseColor("#FFFFFF"));
        familyCharterMembersBinding.text3.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.text4.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort);
        familyCharterMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow4.setImageResource(R.drawable.family_rv_ic_sort1);
        this.charterMembersAdapter.sort1(this.sortcharter1state);
        boolean z = this.sortcharter1state;
        this.sortcharter1state = !z;
        if (!z) {
            familyCharterMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyCharterMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortcharter2() {
        FamilyCharterMembersBinding familyCharterMembersBinding = this.binding.charterMembers;
        familyCharterMembersBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.text3.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.text4.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort);
        familyCharterMembersBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow4.setImageResource(R.drawable.family_rv_ic_sort1);
        this.charterMembersAdapter.sort2(this.sortcharter2state);
        boolean z = this.sortcharter2state;
        this.sortcharter2state = !z;
        if (!z) {
            familyCharterMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyCharterMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortcharter3() {
        FamilyCharterMembersBinding familyCharterMembersBinding = this.binding.charterMembers;
        familyCharterMembersBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.text3.setTextColor(Color.parseColor("#FFFFFF"));
        familyCharterMembersBinding.text4.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort);
        familyCharterMembersBinding.arrow4.setImageResource(R.drawable.family_rv_ic_sort1);
        this.charterMembersAdapter.sort3(this.sortcharter3state);
        boolean z = this.sortcharter3state;
        this.sortcharter3state = !z;
        if (!z) {
            familyCharterMembersBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyCharterMembersBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortcharter4() {
        FamilyCharterMembersBinding familyCharterMembersBinding = this.binding.charterMembers;
        familyCharterMembersBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.text3.setTextColor(Color.parseColor("#99FFFFFF"));
        familyCharterMembersBinding.text4.setTextColor(Color.parseColor("#FFFFFF"));
        familyCharterMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        familyCharterMembersBinding.arrow4.setImageResource(R.drawable.family_rv_ic_sort);
        this.charterMembersAdapter.sort4(this.sortcharter4state);
        boolean z = this.sortcharter4state;
        this.sortcharter4state = !z;
        if (!z) {
            familyCharterMembersBinding.arrow4.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyCharterMembersBinding.arrow4.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortMeetings1() {
        FamilyMeetingsBinding familyMeetingsBinding = this.binding.meetings;
        familyMeetingsBinding.text1.setTextColor(Color.parseColor("#FFFFFF"));
        familyMeetingsBinding.text2.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMeetingsBinding.text3.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMeetingsBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort);
        familyMeetingsBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        familyMeetingsBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        this.meetingsAdapter.sort1(this.sortMeetings1state);
        boolean z = this.sortMeetings1state;
        this.sortMeetings1state = !z;
        if (!z) {
            familyMeetingsBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyMeetingsBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortMeetings2() {
        FamilyMeetingsBinding familyMeetingsBinding = this.binding.meetings;
        familyMeetingsBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMeetingsBinding.text2.setTextColor(Color.parseColor("#FFFFFF"));
        familyMeetingsBinding.text3.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMeetingsBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyMeetingsBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort);
        familyMeetingsBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        this.meetingsAdapter.sort2(this.sortMeetings2state);
        boolean z = this.sortMeetings2state;
        this.sortMeetings2state = !z;
        if (!z) {
            familyMeetingsBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyMeetingsBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortMeetings3() {
        FamilyMeetingsBinding familyMeetingsBinding = this.binding.meetings;
        familyMeetingsBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMeetingsBinding.text2.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMeetingsBinding.text3.setTextColor(Color.parseColor("#FFFFFF"));
        familyMeetingsBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyMeetingsBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        familyMeetingsBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort);
        this.meetingsAdapter.sort3(this.sortMeetings3state);
        boolean z = this.sortMeetings3state;
        this.sortMeetings3state = !z;
        if (!z) {
            familyMeetingsBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyMeetingsBinding.arrow3.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortMembers1() {
        FamilyMembersBinding familyMembersBinding = this.binding.members;
        familyMembersBinding.text1.setTextColor(Color.parseColor("#FFFFFF"));
        familyMembersBinding.text2.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort);
        familyMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        this.membersAdapter.sort1(this.sortMembers1state);
        boolean z = this.sortMembers1state;
        this.sortMembers1state = !z;
        if (!z) {
            familyMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortMembers2() {
        FamilyMembersBinding familyMembersBinding = this.binding.members;
        familyMembersBinding.text1.setTextColor(Color.parseColor("#99FFFFFF"));
        familyMembersBinding.text2.setTextColor(Color.parseColor("#FFFFFF"));
        familyMembersBinding.arrow1.setImageResource(R.drawable.family_rv_ic_sort1);
        familyMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort);
        this.membersAdapter.sort2(this.sortMembers2state);
        boolean z = this.sortMembers2state;
        this.sortMembers2state = !z;
        if (!z) {
            familyMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort);
        } else {
            familyMembersBinding.arrow2.setImageResource(R.drawable.family_rv_ic_sort1);
        }
    }

    private final void navigateTo(Navigation navigation) {
        String str;
        this.binding.create.getRoot().setVisibility(8);
        this.binding.menu.getRoot().setVisibility(8);
        this.binding.settings.getRoot().setVisibility(8);
        this.binding.members.getRoot().setVisibility(8);
        this.binding.rating.getRoot().setVisibility(8);
        this.binding.map.getRoot().setVisibility(8);
        this.binding.estate.getRoot().setVisibility(8);
        this.binding.charter.getRoot().setVisibility(8);
        this.binding.war.getRoot().setVisibility(8);
        this.binding.home.getRoot().setVisibility(8);
        this.binding.territories.getRoot().setVisibility(8);
        this.binding.charterMembers.getRoot().setVisibility(8);
        this.binding.meetings.getRoot().setVisibility(8);
        this.binding.frameMap.getRoot().setVisibility(8);
        this.binding.frameMember.getRoot().setVisibility(8);
        this.binding.frameCharter.getRoot().setVisibility(8);
        FamilyTopbarBinding familyTopbarBinding = this.binding.topbar;
        familyTopbarBinding.title.setVisibility(8);
        familyTopbarBinding.titleCreate.setVisibility(8);
        familyTopbarBinding.backButton.setVisibility(0);
        familyTopbarBinding.getRoot().setVisibility(0);
        familyTopbarBinding.nameContainer.setVisibility(0);
        familyTopbarBinding.createMoneyInfo.setVisibility(8);
        familyTopbarBinding.mainMenuContainer.setVisibility(8);
        familyTopbarBinding.homeContainer.setVisibility(8);
        familyTopbarBinding.settingsContainer.setVisibility(8);
        familyTopbarBinding.serverName.setVisibility(8);
        familyTopbarBinding.ratingContainer.setVisibility(8);
        familyTopbarBinding.searchContainer.setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()]) {
            case 1:
                this.binding.create.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding2 = this.binding.topbar;
                familyTopbarBinding2.title.setVisibility(8);
                familyTopbarBinding2.titleCreate.setVisibility(0);
                familyTopbarBinding2.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda50
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$101$lambda$100(view);
                    }
                });
                familyTopbarBinding2.backButton.setVisibility(4);
                familyTopbarBinding2.createMoneyInfo.setVisibility(0);
                Intrinsics.checkNotNull(familyTopbarBinding2);
                return;
            case 2:
                this.binding.menu.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding3 = this.binding.topbar;
                familyTopbarBinding3.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda59
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$103$lambda$102(view);
                    }
                });
                familyTopbarBinding3.backButton.setVisibility(8);
                familyTopbarBinding3.mainMenuContainer.setVisibility(0);
                Intrinsics.checkNotNull(familyTopbarBinding3);
                return;
            case 3:
                this.binding.settings.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding4 = this.binding.topbar;
                familyTopbarBinding4.title.setText("Управление семьей");
                familyTopbarBinding4.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda60
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$105$lambda$104(FamilyScreen.this, view);
                    }
                });
                familyTopbarBinding4.settingsContainer.setVisibility(0);
                familyTopbarBinding4.title.setVisibility(0);
                Intrinsics.checkNotNull(familyTopbarBinding4);
                return;
            case 4:
                this.binding.estate.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding5 = this.binding.topbar;
                familyTopbarBinding5.title.setVisibility(0);
                TextView textView = familyTopbarBinding5.title;
                FamilyData familyData = this.familyData;
                if (familyData == null || familyData.getHasEstate() != 1) {
                }
                textView.setText(str);
                familyTopbarBinding5.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda61
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$107$lambda$106(FamilyScreen.this, view);
                    }
                });
                Intrinsics.checkNotNull(familyTopbarBinding5);
                return;
            case 5:
                this.binding.charter.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding6 = this.binding.topbar;
                familyTopbarBinding6.title.setText("Частная фракция");
                familyTopbarBinding6.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda62
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$109$lambda$108(FamilyScreen.this, view);
                    }
                });
                Intrinsics.checkNotNull(familyTopbarBinding6);
                return;
            case 6:
                this.binding.war.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding7 = this.binding.topbar;
                familyTopbarBinding7.title.setVisibility(0);
                familyTopbarBinding7.title.setText("Войны за территории");
                familyTopbarBinding7.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda63
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$111$lambda$110(FamilyScreen.this, view);
                    }
                });
                requestMeetings();
                requestTopTerritories();
                return;
            case 7:
                this.binding.home.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding8 = this.binding.topbar;
                familyTopbarBinding8.title.setText("Настройки");
                familyTopbarBinding8.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda64
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$113$lambda$112(FamilyScreen.this, view);
                    }
                });
                familyTopbarBinding8.homeContainer.setVisibility(0);
                loadMembersCount();
                return;
            case 8:
                this.binding.members.getRoot().setVisibility(0);
                final FamilyTopbarBinding familyTopbarBinding9 = this.binding.topbar;
                familyTopbarBinding9.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda65
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$118$lambda$114(FamilyScreen.this, view);
                    }
                });
                familyTopbarBinding9.searchContainer.setVisibility(0);
                familyTopbarBinding9.ratingBtn.setVisibility(0);
                familyTopbarBinding9.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda67
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                        boolean navigateTo$lambda$118$lambda$115;
                        navigateTo$lambda$118$lambda$115 = FamilyScreen.navigateTo$lambda$118$lambda$115(FamilyTopbarBinding.this, textView2, i, keyEvent);
                        return navigateTo$lambda$118$lambda$115;
                    }
                });
                familyTopbarBinding9.editText.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$navigateTo$9$3
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        Editable editable2 = editable;
                        if (editable2 == null || editable2.length() == 0) {
                            FamilyTopbarBinding.this.searchBtn.performClick();
                        }
                    }
                });
                familyTopbarBinding9.searchBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda68
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$118$lambda$117(FamilyScreen.this, familyTopbarBinding9, view);
                    }
                });
                sortMembers1();
                this.membersAdapter.clearList();
                FamilyMembersBinding familyMembersBinding = this.binding.members;
                familyMembersBinding.loaderBar.setVisibility(0);
                familyMembersBinding.empty.setVisibility(8);
                requestMembers(1);
                return;
            case 9:
                this.binding.charterMembers.getRoot().setVisibility(0);
                final FamilyTopbarBinding familyTopbarBinding10 = this.binding.topbar;
                familyTopbarBinding10.title.setText("Состав организации");
                familyTopbarBinding10.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda51
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$124$lambda$120(FamilyScreen.this, view);
                    }
                });
                familyTopbarBinding10.searchContainer.setVisibility(0);
                familyTopbarBinding10.ratingBtn.setVisibility(8);
                familyTopbarBinding10.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda52
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                        boolean navigateTo$lambda$124$lambda$121;
                        navigateTo$lambda$124$lambda$121 = FamilyScreen.navigateTo$lambda$124$lambda$121(FamilyTopbarBinding.this, textView2, i, keyEvent);
                        return navigateTo$lambda$124$lambda$121;
                    }
                });
                familyTopbarBinding10.editText.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$navigateTo$11$3
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        Editable editable2 = editable;
                        if (editable2 == null || editable2.length() == 0) {
                            FamilyTopbarBinding.this.searchBtn.performClick();
                        }
                    }
                });
                familyTopbarBinding10.searchBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda53
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$124$lambda$123(FamilyScreen.this, familyTopbarBinding10, view);
                    }
                });
                sortcharter1();
                this.charterMembersAdapter.clearList();
                FamilyCharterMembersBinding familyCharterMembersBinding = this.binding.charterMembers;
                familyCharterMembersBinding.loaderBar.setVisibility(0);
                familyCharterMembersBinding.empty.setVisibility(8);
                requestCharterMembers(1);
                return;
            case 10:
                this.binding.rating.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding11 = this.binding.topbar;
                familyTopbarBinding11.title.setText("Рейтинг семей сервера ");
                familyTopbarBinding11.serverName.setText(ServersKt.familyServers(this.serverId));
                familyTopbarBinding11.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda54
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$127$lambda$126(FamilyScreen.this, view);
                    }
                });
                familyTopbarBinding11.serverName.setVisibility(0);
                familyTopbarBinding11.title.setVisibility(0);
                familyTopbarBinding11.ratingContainer.setVisibility(0);
                this.ratingAdapter.clearList();
                FamilyRatingBinding familyRatingBinding = this.binding.rating;
                familyRatingBinding.loaderBar.setVisibility(0);
                familyRatingBinding.empty.setVisibility(8);
                requestRating(1);
                return;
            case 11:
                this.binding.map.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding12 = this.binding.topbar;
                familyTopbarBinding12.title.setText("Семейные войны");
                familyTopbarBinding12.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda56
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$130$lambda$129(FamilyScreen.this, view);
                    }
                });
                setMap();
                return;
            case 12:
                this.binding.territories.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding13 = this.binding.topbar;
                familyTopbarBinding13.title.setText("Наши территории");
                familyTopbarBinding13.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda57
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$132$lambda$131(FamilyScreen.this, view);
                    }
                });
                sortTerritory1();
                this.territoryAdapter.clearList();
                FamilyTerritoriesBinding familyTerritoriesBinding = this.binding.territories;
                familyTerritoriesBinding.loaderBar.setVisibility(0);
                familyTerritoriesBinding.empty.setVisibility(8);
                requestTerritories();
                return;
            case 13:
                this.binding.meetings.getRoot().setVisibility(0);
                FamilyTopbarBinding familyTopbarBinding14 = this.binding.topbar;
                familyTopbarBinding14.title.setVisibility(0);
                familyTopbarBinding14.title.setText("Список встреч");
                familyTopbarBinding14.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.FamilyScreen$$ExternalSyntheticLambda58
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FamilyScreen.navigateTo$lambda$135$lambda$134(FamilyScreen.this, view);
                    }
                });
                sortMeetings1();
                this.meetingsAdapter.clearList();
                FamilyMeetingsBinding familyMeetingsBinding = this.binding.meetings;
                familyMeetingsBinding.loaderBar.setVisibility(0);
                familyMeetingsBinding.empty.setVisibility(8);
                requestMeetings();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$105$lambda$104(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$107$lambda$106(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$109$lambda$108(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$111$lambda$110(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$113$lambda$112(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$118$lambda$114(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean navigateTo$lambda$118$lambda$115(FamilyTopbarBinding familyTopbarBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            familyTopbarBinding.searchBtn.performClick();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$118$lambda$117(FamilyScreen familyScreen, FamilyTopbarBinding familyTopbarBinding, View view) {
        familyScreen.membersAdapter.clearList();
        FamilyMembersBinding familyMembersBinding = familyScreen.binding.members;
        familyMembersBinding.loaderBar.setVisibility(0);
        familyMembersBinding.empty.setVisibility(8);
        familyTopbarBinding.editText.clearFocus();
        String obj = StringsKt.trim((CharSequence) familyTopbarBinding.editText.getText().toString()).toString();
        if (obj.length() == 0) {
            familyScreen.requestMembers(1);
        } else {
            familyScreen.requestMembersName(obj);
        }
        ((InputMethodManager) familyScreen.getTargetActivity().getSystemService(InputMethodManager.class)).hideSoftInputFromWindow(familyScreen.binding.getRoot().getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$124$lambda$120(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Charter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean navigateTo$lambda$124$lambda$121(FamilyTopbarBinding familyTopbarBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            familyTopbarBinding.searchBtn.performClick();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$124$lambda$123(FamilyScreen familyScreen, FamilyTopbarBinding familyTopbarBinding, View view) {
        familyScreen.charterMembersAdapter.clearList();
        FamilyCharterMembersBinding familyCharterMembersBinding = familyScreen.binding.charterMembers;
        familyCharterMembersBinding.loaderBar.setVisibility(0);
        familyCharterMembersBinding.empty.setVisibility(8);
        familyTopbarBinding.editText.clearFocus();
        String obj = StringsKt.trim((CharSequence) familyTopbarBinding.editText.getText().toString()).toString();
        if (obj.length() == 0) {
            familyScreen.requestCharterMembers(1);
        } else {
            familyScreen.requestCharterMembersName(obj);
        }
        ((InputMethodManager) familyScreen.getTargetActivity().getSystemService(InputMethodManager.class)).hideSoftInputFromWindow(familyScreen.binding.getRoot().getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$127$lambda$126(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$130$lambda$129(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.War);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$132$lambda$131(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.War);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$135$lambda$134(FamilyScreen familyScreen, View view) {
        familyScreen.navigateTo(Navigation.War);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FamilyScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lru/mrlargha/arizonaui/family/FamilyScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Create", "Menu", "Settings", "Members", "Rating", "Map", "Estate", "Charter", "War", "Home", "CharterMembers", "Territories", "Meetings", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Create = new Navigation("Create", 0);
        public static final Navigation Menu = new Navigation("Menu", 1);
        public static final Navigation Settings = new Navigation("Settings", 2);
        public static final Navigation Members = new Navigation("Members", 3);
        public static final Navigation Rating = new Navigation("Rating", 4);
        public static final Navigation Map = new Navigation("Map", 5);
        public static final Navigation Estate = new Navigation("Estate", 6);
        public static final Navigation Charter = new Navigation("Charter", 7);
        public static final Navigation War = new Navigation("War", 8);
        public static final Navigation Home = new Navigation("Home", 9);
        public static final Navigation CharterMembers = new Navigation("CharterMembers", 10);
        public static final Navigation Territories = new Navigation("Territories", 11);
        public static final Navigation Meetings = new Navigation("Meetings", 12);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Create, Menu, Settings, Members, Rating, Map, Estate, Charter, War, Home, CharterMembers, Territories, Meetings};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: FamilyScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/family/FamilyScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new FamilyScreen(targetActivity, i);
        }
    }
}
