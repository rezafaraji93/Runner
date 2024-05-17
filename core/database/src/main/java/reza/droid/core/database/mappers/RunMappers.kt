package reza.droid.core.database.mappers

import org.bson.types.ObjectId
import reza.droid.core.database.entity.RunEntity
import reza.droid.core.domain.location.Location
import reza.droid.core.domain.run.Run
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunEntity.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc)
            .atZone(ZoneId.of("UTC")),
        distanceMeters = distanceMeters,
        location = Location(
            lat = latitude,
            long = longitude
        ),
        maxSpeedKmh = maxSpeedKmh,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toRunEntity(): RunEntity {
    return RunEntity(
        id = id ?: ObjectId().toHexString(),
        durationMillis = duration.inWholeMilliseconds,
        maxSpeedKmh = maxSpeedKmh,
        dateTimeUtc = dateTimeUtc.toInstant().toString(),
        latitude = location.lat,
        longitude = location.long,
        distanceMeters = distanceMeters,
        avgSpeedKmh = avgSpeedKmh,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl
    )
}