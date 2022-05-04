package com.gccoffee.domain.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@EqualsAndHashCode
@ToString
public class Email {
    private final String address;

    public Email(String address) {
        checkNotNull(address);
        checkArgument(address.length() >= 4 && address.length() <= 50, "email은 4자 이상 50자 이하");
        checkArgument(checkAddress(address), "email regex 만족");

        this.address = address;
    }

    private static boolean checkAddress(String address) {
        return Pattern.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b", address);
    }

}
