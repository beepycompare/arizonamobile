package ru.mrlargha.feature.mobile.presentation.page.messenger.api;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.common.net.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.mrlargha.feature.mobile.presentation.page.messenger.api.obj.ChatMessageApiResponse;
import ru.mrlargha.feature.mobile.presentation.page.messenger.api.obj.ContactApiResponse;
import ru.mrlargha.feature.mobile.presentation.page.messenger.api.obj.SettingsApiResponse;
/* compiled from: MessagesApi.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0084\u0001\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u0010\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u0010H'b\f\b\u0011\u0012\b\b\t\u0012\u0004\b\b(\u0012J\u0089\u0001\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u0010\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u0015H'b\f\b\u0011\u0012\b\b\t\u0012\u0004\b\b(\u0017¢\u0006\u0002\u0010\u0016J\u0089\u0001\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u00152\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u0010\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u0010H'b\f\b\u0011\u0012\b\b\t\u0012\u0004\b\b(\u0017¢\u0006\u0002\u0010\u0019J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nH'b\f\b\u0011\u0012\b\b\t\u0012\u0004\b\b(\u001cJ\u0082\u0001\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0016\b\u0001\u0010\u001f\u001a\u00020\u0007:\f\b \u0012\b\b\t\u0012\u0004\b\b(\u00152\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u0010\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(\u0010H'b\f\b\u0011\u0012\b\b\t\u0012\u0004\b\b(!Jd\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0016\b\u0001\u0010\u0015\u001a\u00020\u000f:\f\b \u0012\b\b\t\u0012\u0004\b\b(\u00152\u0016\b\u0001\u0010#\u001a\u00020\u000f:\f\b\f\u0012\b\b\t\u0012\u0004\b\b(#H'b\f\b\u0011\u0012\b\b\t\u0012\u0004\b\b($¨\u0006%À\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/messenger/api/MessagesApi;", "", "findContact", "Lretrofit2/Call;", "", "Lru/mrlargha/feature/mobile/presentation/page/messenger/api/obj/ContactApiResponse;", "token", "", "Lretrofit2/http/Header;", "value", HttpHeaders.AUTHORIZATION, SettingsConstants.NICKNAME, "Lretrofit2/http/Query;", SearchIntents.EXTRA_QUERY, "limit", "", "page", "Lretrofit2/http/GET;", "contacts", "getMessages", "dialogId", TtmlNode.ATTR_ID, "(Ljava/lang/String;IILjava/lang/Integer;)Lretrofit2/Call;", "chats", "getMessage", "(Ljava/lang/String;Ljava/lang/Integer;II)Lretrofit2/Call;", "getSettings", "Lru/mrlargha/feature/mobile/presentation/page/messenger/api/obj/SettingsApiResponse;", "config", "getChatMessages", "Lru/mrlargha/feature/mobile/presentation/page/messenger/api/obj/ChatMessageApiResponse;", "contactId", "Lretrofit2/http/Path;", "chats/{id}/messages", "getContactInfo", "tel", "contact/{id}", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface MessagesApi {
    @GET("contacts")
    Call<List<ContactApiResponse>> findContact(@Header("Authorization") String str, @Query("query") String str2, @Query("limit") int i, @Query("page") int i2);

    @GET("chats/{id}/messages")
    Call<List<ChatMessageApiResponse>> getChatMessages(@Header("Authorization") String str, @Path("id") String str2, @Query("limit") int i, @Query("page") int i2);

    @GET("contact/{id}")
    Call<ContactApiResponse> getContactInfo(@Header("Authorization") String str, @Path("id") int i, @Query("tel") int i2);

    @GET("chats")
    Call<List<ContactApiResponse>> getMessage(@Header("Authorization") String str, @Query("id") Integer num, @Query("limit") int i, @Query("page") int i2);

    @GET("chats")
    Call<List<ContactApiResponse>> getMessages(@Header("Authorization") String str, @Query("limit") int i, @Query("page") int i2, @Query("id") Integer num);

    @GET("config")
    Call<SettingsApiResponse> getSettings(@Header("Authorization") String str);

    /* compiled from: MessagesApi.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Call findContact$default(MessagesApi messagesApi, String str, String str2, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = null;
            }
            if ((i3 & 4) != 0) {
                i = 20;
            }
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            return messagesApi.findContact(str, str2, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findContact");
    }

    static /* synthetic */ Call getMessages$default(MessagesApi messagesApi, String str, int i, int i2, Integer num, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 20;
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            if ((i3 & 8) != 0) {
                num = null;
            }
            return messagesApi.getMessages(str, i, i2, num);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessages");
    }

    static /* synthetic */ Call getMessage$default(MessagesApi messagesApi, String str, Integer num, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                num = null;
            }
            if ((i3 & 4) != 0) {
                i = 1;
            }
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            return messagesApi.getMessage(str, num, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessage");
    }

    static /* synthetic */ Call getChatMessages$default(MessagesApi messagesApi, String str, String str2, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i = 20;
            }
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            return messagesApi.getChatMessages(str, str2, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChatMessages");
    }
}
