package lintcode;

public class Valid_number {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		s = s.trim();
		if (s.length() == 0)
			return false; // "      "

		boolean hasNum = false; // number
		boolean canDot = true;
		boolean canSign = true;
		boolean canE = false;
		boolean hasE = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ')
				return false; // ' '

			if (c == '+' || c == '-') {
				if (!canSign)
					return false;

				canSign = false;
				continue;
			}

			if (c == '.') {
				if (!canDot)
					return false;

				canDot = false;
				canSign = false;
				continue;
			}

			if (c == 'e') {
				if (!canE)
					return false;

				canSign = true;
				canE = false;
				hasE = true;
				canDot = false;
				hasNum = false;
				continue;
			}

			if (c >= '0' && c <= '9') {
				hasNum = true;
				if (!canE && !hasE)
					canE = true;

				canSign = false;
			} else {
				return false;
			}
		}
		return hasNum;
	}
}
