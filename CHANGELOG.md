# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Fixed

-   Fixed the code coverage report path.

## [0.16.5] - 2024-07-14

### Fixed

-   The `validate-branch-name` action now allows `NO-ISSUE` instead of a `GH-` issue prefix.
-   The `resolve-issue-locking` action now just runs once a week.

## [0.16.4] - 2024-07-10

### Fixed

-   The root plugin no longer registers an extension. Apply `refinedarchitect.base` to get the `refinedarchitect` extension.

## [0.16.3] - 2024-07-10

### Fixed

-   The `sonarQube` function is now available in each plugin instead of only on the root plugin.

## [0.16.2] - 2024-07-08

## [0.16.1] - 2024-07-08

## [0.16.0] - 2024-07-08

### Added

-   Replaced the `helper.gradle` file with a Gradle convention plugin.
-   Support for Parchment.

## [0.15.3] - 2024-07-06

### Fixed

-   Updated NeoForge to 21.0.61-beta.

## [0.15.2] - 2024-07-06

### Fixed

-   Fixed remapping issue in Fabric dev environment for consumers of the Fabric project artifact.

## [0.15.1] - 2024-07-05

### Fixed

-   Renamed `forgeProject` to `neoForgeProject`.

## [0.15.0] - 2024-07-05

### Changed

-   Switched from NeoGradle to ModDevGradle.
-   Upgrade cache and Gradle wrapper validation actions.
-   Disable implicit compilation in Sonar Gradle plugin.

## [0.14.3] - 2024-07-03

### Fixed

-   Fix problem where code coverage report couldn't be generated.

## [0.14.2] - 2024-06-29

### Fixed

-   Wrong Slf4j version.

## [0.14.1] - 2024-06-29

### Fixed

-   Wrong NeoForge version.

## [0.14.0] - 2024-06-29

### Changed

-   Ported to Minecraft 1.21.

## [0.13.4] - 2024-06-15

### Fixed

-   Declare Fabric APIs and common project as API instead of implementation.

## [0.13.3] - 2024-06-15

### Fixed

-   Declare Fabric APIs and common project as API instead of implementation.

## [0.13.2] - 2024-06-09

### Fixed

-   Use Cloth Config for Fabric.

## [0.13.1] - 2024-06-09

### Fixed

-   Invalid version ref for cloth config.

## [0.13.0] - 2024-06-09

### Changed

-   Removed Fabric, Forge and common version catalogs.

## [0.12.1] - 2024-05-25

### Fixed

-   Updated Gradle.
-   Include NeoForge testframework.

## [0.12.0] - 2024-05-25

### Added

-   Support for NeoForge gametests.

## [0.11.5] - 2024-03-16

### Fixed

-   Branch name validation for Crowdin translation branches no longer fails.

## [0.11.4] - 2024-01-29

### Fixed

-   Updated CurseForge plugin to properly detect NeoForge.

## [0.11.3] - 2024-01-28

### Fixed

-   Pitest and JUnit incompatibility.

## [0.11.2] - 2024-01-28

### Fixed

-   Checkstyle incompatibility with Guava.

## [0.11.1] - 2024-01-28

### Fixed

-   NeoForge JEI version.
-   Cloth Config version.

## [0.11.0] - 2024-01-28

### Changed

-   Ported to Minecraft 1.20.4.

## [0.10.0] - 2023-12-25

### Changed

-   Upgraded GitHub Actions versions.

## [0.9.1] - 2023-10-31

### Fixed

-   Mixin support for data generation on Forge.

## [0.9.0] - 2023-09-02

### Added

-   Mixin support on Forge.

## [0.8.2] - 2023-08-22

### Fixed

-   Fixed more Pitest compatibility issues.

## [0.8.1] - 2023-08-20

### Fixed

-   Fixed Pitest compatibility issue.

## [0.8.0] - 2023-08-20

### Added

-   The Forge helpers now use NeoForge instead of Forge.

### Changed

-   Bumped various library versions.

## [0.7.1] - 2023-07-07

### Fixed

-   Added ability to set changelog validation warning level.

## [0.7.0] - 2023-07-07

### Changed

-   Javadoc publishing is now configurable.
-   Javadoc publishing now happens on the refinedmods/javadoc repo.

## [0.6.0] - 2023-07-05

### Added

-   Modrinth upload support.

## [0.5.5] - 2023-07-04

### Fixed

-   Code coverage report task is now properly dependent on test task.

## [0.5.4] - 2023-07-03

### Fixed

-   Suppress Javadoc generation failures.

## [0.5.3] - 2023-07-03

### Fixed

-   Javadoc not generating for single-project builds.

## [0.5.2] - 2023-07-03

### Fixed

-   CurseForge upload display name.

## [0.5.1] - 2023-07-03

### Fixed

-   Gradle helper for single-project builds.

## [0.5.0] - 2023-07-03

### Added

-   CurseForge upload support.

### Changed

-   Ported to Minecraft 1.20.1

## [0.4.2] - 2023-06-20

### Fixed

-   Upgraded Sonar Gradle plugin.

## [0.4.1] - 2023-06-13

### Fixed

-   Fixed build errors by removing Foojay convention plugin.

## [0.4.0] - 2023-05-29

### Changed

-   Upgraded Gradle to v8.1.1.
-   Upgraded ForgeGradle to v6.
-   Upgraded Fabric Loom to v1.2.

## [0.3.1] - 2023-05-29

### Fixed

-   Fixed Parchment version.

## [0.3.0] - 2023-05-29

### Changed

-   Ported to Minecraft 1.19.4.

## [0.2.0] - 2023-03-20

### Changed

-   It's no longer necessary to provide the common project under the `compileApis` argument for `forgeProject` and
    `fabricProject`.

## [0.1.0] - 2023-03-19

### Changed

-   Publishing to Maven is now opt-in with `enablePublishing`.
-   Announcing new releases is now configurable.

## [0.0.2] - 2023-03-19

### Fixed

-   Fixed using relative path for `setup-java` in build and publish workflow.

## [0.0.1] - 2023-03-19

### Added

-   Version catalogs.
-   Gradle helpers for Checkstyle, Pitest, etc.
-   Gradle helpers for Fabric and Forge projects.
-   CI workflows.

[Unreleased]: https://github.com/refinedmods/refinedarchitect/compare/v0.16.5...HEAD

[0.16.5]: https://github.com/refinedmods/refinedarchitect/compare/v0.16.4...v0.16.5

[0.16.4]: https://github.com/refinedmods/refinedarchitect/compare/v0.16.3...v0.16.4

[0.16.3]: https://github.com/refinedmods/refinedarchitect/compare/v0.16.2...v0.16.3

[0.16.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.16.1...v0.16.2

[0.16.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.16.0...v0.16.1

[0.16.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.15.3...v0.16.0

[0.15.3]: https://github.com/refinedmods/refinedarchitect/compare/v0.15.2...v0.15.3

[0.15.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.15.1...v0.15.2

[0.15.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.15.0...v0.15.1

[0.15.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.14.3...v0.15.0

[0.14.3]: https://github.com/refinedmods/refinedarchitect/compare/v0.14.2...v0.14.3

[0.14.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.14.1...v0.14.2

[0.14.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.14.0...v0.14.1

[0.14.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.13.4...v0.14.0

[0.13.4]: https://github.com/refinedmods/refinedarchitect/compare/v0.13.3...v0.13.4

[0.13.3]: https://github.com/refinedmods/refinedarchitect/compare/v0.13.2...v0.13.3

[0.13.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.13.1...v0.13.2

[0.13.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.13.0...v0.13.1

[0.13.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.12.1...v0.13.0

[0.12.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.12.0...v0.12.1

[0.12.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.11.5...v0.12.0

[0.11.5]: https://github.com/refinedmods/refinedarchitect/compare/v0.11.4...v0.11.5

[0.11.4]: https://github.com/refinedmods/refinedarchitect/compare/v0.11.3...v0.11.4

[0.11.3]: https://github.com/refinedmods/refinedarchitect/compare/v0.11.2...v0.11.3

[0.11.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.11.1...v0.11.2

[0.11.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.11.0...v0.11.1

[0.11.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.10.0...v0.11.0

[0.10.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.9.1...v0.10.0

[0.9.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.9.0...v0.9.1

[0.9.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.8.2...v0.9.0

[0.8.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.8.1...v0.8.2

[0.8.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.8.0...v0.8.1

[0.8.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.7.1...v0.8.0

[0.7.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.7.0...v0.7.1

[0.7.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.6.0...v0.7.0

[0.6.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.5.5...v0.6.0

[0.5.5]: https://github.com/refinedmods/refinedarchitect/compare/v0.5.4...v0.5.5

[0.5.4]: https://github.com/refinedmods/refinedarchitect/compare/v0.5.3...v0.5.4

[0.5.3]: https://github.com/refinedmods/refinedarchitect/compare/v0.5.2...v0.5.3

[0.5.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.5.1...v0.5.2

[0.5.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.5.0...v0.5.1

[0.5.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.4.2...v0.5.0

[0.4.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.4.1...v0.4.2

[0.4.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.4.0...v0.4.1

[0.4.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.3.1...v0.4.0

[0.3.1]: https://github.com/refinedmods/refinedarchitect/compare/v0.3.0...v0.3.1

[0.3.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.2.0...v0.3.0

[0.2.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.1.0...v0.2.0

[0.1.0]: https://github.com/refinedmods/refinedarchitect/compare/v0.0.2...v0.1.0

[0.0.2]: https://github.com/refinedmods/refinedarchitect/compare/v0.0.1...v0.0.2

[0.0.1]: https://github.com/refinedmods/refinedarchitect/compare/61e387b9810833cbe7c23b9fdf8c493e212ecba9...v0.0.1
