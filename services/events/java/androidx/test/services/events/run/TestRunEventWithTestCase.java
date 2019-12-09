/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.test.services.events.run;

import android.os.Parcel;
import androidx.test.services.events.TestCase;

/** Represents a {@link TestRunEvent} with an associated {@link TestCase}. */
public abstract class TestRunEventWithTestCase extends TestRunEvent {
  /** The {@link TestCase} this event is associated with. */
  public final TestCase testCase;

  /**
   * Creates a {@link TestRunEventWithTestCase} from an {@link Parcel}.
   *
   * @param source {@link Parcel} to create the {@link TestCase} from
   */
  TestRunEventWithTestCase(Parcel source) {
    testCase = new TestCase(source);
  }

  /**
   * Creates a {@link TestRunEventWithTestCase}.
   *
   * @param testCase the test case this event represents,
   */
  TestRunEventWithTestCase(TestCase testCase) {
    this.testCase = testCase;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    super.writeToParcel(parcel, i);
    testCase.writeToParcel(parcel, i);
  }
}
