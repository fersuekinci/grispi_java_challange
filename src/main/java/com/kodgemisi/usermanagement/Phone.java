package com.kodgemisi.usermanagement;

/**
 * Represents a phone number, never stores a null value. If constructed with a null value stores an empty string.
 */
public class Phone implements CharSequence {

	private final String phoneNumber;

	public Phone(String phoneNumber) {
		isValid(phoneNumber);
		this.phoneNumber = phoneNumber == null ? "" : phoneNumber;
	}

	public String number() {
		return phoneNumber;
	}

	@Override
	public int length() {
		return phoneNumber.length();
	}

	@Override
	public char charAt(int index) {
		return phoneNumber.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return phoneNumber.subSequence(start, end);
	}

	@Override
	public String toString() {
		return phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Phone phone = (Phone) o;

		return phoneNumber.equals(phone.phoneNumber);
	}

	@Override
	public int hashCode() {
		return phoneNumber.hashCode();
	}

	public boolean isValid(String phoneNumber) {
		if(phoneNumber==null || phoneNumber.equals("")) {
			throw new IllegalArgumentException("A phone number cannot be null or empty");
		}
		else {
			if(phoneNumber.subSequence(0,1).equals("+")) {
				if(phoneNumber.length()<5) {
					throw new IllegalArgumentException("A phone number should be at least 5-char long");
				}
				else if(phoneNumber.subSequence(1,3).equals("90") && phoneNumber.length() !=13) {
					throw new IllegalArgumentException("A phone number should be exactly 13-char long");
				}
			}
			else if(!phoneNumber.equals("112") && !phoneNumber.equals("911")) {
				throw new IllegalArgumentException("A phone number should start with + sign");
			}
		}
		return true;
	}
}
