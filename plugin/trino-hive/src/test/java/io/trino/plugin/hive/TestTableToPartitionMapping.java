/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.plugin.hive;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static io.trino.plugin.hive.TableToPartitionMapping.isIdentityMapping;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTableToPartitionMapping
{
    @Test
    public void testIsOneToOneMapping()
    {
        assertThat(isIdentityMapping(ImmutableMap.<Integer, Integer>builder()
                .put(0, 0)
                .put(1, 1)
                .put(2, 2)
                .put(3, 3)
                .buildOrThrow())).isTrue();
        assertThat(isIdentityMapping(ImmutableMap.<Integer, Integer>builder()
                .put(0, 0)
                .put(1, 1)
                .put(2, 2)
                .put(3, 3)
                .put(5, 5)
                .buildOrThrow())).isFalse();
        assertThat(isIdentityMapping(ImmutableMap.<Integer, Integer>builder()
                .put(0, 0)
                .put(1, 1)
                .put(2, 2)
                .put(4, 5)
                .buildOrThrow())).isFalse();
    }
}
