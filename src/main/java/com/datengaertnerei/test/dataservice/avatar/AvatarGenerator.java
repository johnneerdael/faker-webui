/*MIT License

Copyright (c) 2020 Jens Dibbern

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.datengaertnerei.test.dataservice.avatar;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.eightbit.EightBitAvatar;

@Service
public class AvatarGenerator implements IAvatarGenerator {
	private Random rnd;

	public AvatarGenerator() {
		rnd = new Random();
		rnd.setSeed(System.currentTimeMillis());
	}

	@Override
	public byte[] getAvatar(boolean female) {
		Avatar avatar = null;

		if (female) {
			avatar = EightBitAvatar.newFemaleAvatarBuilder().build();
		} else {
			avatar = EightBitAvatar.newMaleAvatarBuilder().build();
		}

		return avatar.createAsPngBytes(rnd.nextLong());
	}

}
