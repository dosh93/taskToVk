package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AttachType {

    FILE("ms_item_doc"),
    PHOTO("ms_item_photo"),
    AUDIO("ms_item_audio");

    @Getter
    private final String nameClass;
}
