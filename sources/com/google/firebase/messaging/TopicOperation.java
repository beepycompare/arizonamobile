package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
final class TopicOperation {
    private static final String OLD_TOPIC_PREFIX = "/topics/";
    static final String OPERATION_PAIR_DIVIDER = "!";
    private static final String TOPIC_NAME_PATTERN = "[a-zA-Z0-9-_.~%]{1,900}";
    private static final Pattern TOPIC_NAME_REGEXP = Pattern.compile(TOPIC_NAME_PATTERN);
    private final String operation;
    private final String serializedString;
    private final String topic;

    private TopicOperation(String str, String str2) {
        this.topic = normalizeTopicOrThrow(str2, str);
        this.operation = str;
        this.serializedString = str + OPERATION_PAIR_DIVIDER + str2;
    }

    private static String normalizeTopicOrThrow(String str, String str2) {
        if (str != null && str.startsWith(OLD_TOPIC_PREFIX)) {
            Log.w(Constants.TAG, String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(OLD_TOPIC_PREFIX.length());
        }
        if (str == null || !TOPIC_NAME_REGEXP.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, TOPIC_NAME_PATTERN));
        }
        return str;
    }

    public static TopicOperation subscribe(String str) {
        return new TopicOperation(ExifInterface.LATITUDE_SOUTH, str);
    }

    public static TopicOperation unsubscribe(String str) {
        return new TopicOperation("U", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TopicOperation from(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(OPERATION_PAIR_DIVIDER, -1);
        if (split.length != 2) {
            return null;
        }
        return new TopicOperation(split[0], split[1]);
    }

    public String getTopic() {
        return this.topic;
    }

    public String getOperation() {
        return this.operation;
    }

    public String serialize() {
        return this.serializedString;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TopicOperation) {
            TopicOperation topicOperation = (TopicOperation) obj;
            return this.topic.equals(topicOperation.topic) && this.operation.equals(topicOperation.operation);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.operation, this.topic);
    }
}
