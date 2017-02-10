
package entities;

import java.util.Objects;

public class Word {

	private final String value;
	public final String key;
	private int frequency;

	public static Word New(String value) { return new Word(value); }

	private Word(String value) {
		this.value = value;
		key = value.trim();
	}

	public String getValue() {
		return value;
	}

	public int getFrequency() {
		return frequency;
	}

	public void incrementFrequency() {
		frequency++;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + Objects.hashCode(this.value);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Word other = (Word) obj;
		return this.value.equals(other.value);
	}

	@Override
	public String toString() {
		return "Word: [" + value + " | " + frequency + "]";
	}

	

}