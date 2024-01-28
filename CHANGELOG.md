# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

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

[Unreleased]: https://github.com/refinedmods/refinedarchitect/compare/v0.11.2...HEAD

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
