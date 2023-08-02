package ru.khamedov.ildar.store.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.commons.io.IOUtils;
import org.zkoss.util.media.Media;
import ru.khamedov.ildar.store.model.description.ImageContent;
import ru.khamedov.ildar.store.model.description.ImageFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Utils {

    public static boolean isValidPhoneNumber(CharSequence numberToParse) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(numberToParse,
                Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name());
        return phoneNumberUtil.isValidNumber(phoneNumber);
    }

    public static ImageFile loadImageFile(Media media, ImageFile imageFile) throws IOException {
        String contentType = media.getContentType();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(media.getStreamData(), byteArrayOutputStream);
        byte[] pictureBytes = byteArrayOutputStream.toByteArray();
        ImageContent imageContent = new ImageContent();
        imageContent.setContent(pictureBytes);
        imageFile.setLength(imageContent.getContent().length);
        imageFile.setImageContent(imageContent);
        imageFile.setContentType(contentType);
        return imageFile;
    }

}
