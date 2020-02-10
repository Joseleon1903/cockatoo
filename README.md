# Cockatoo


This document describes the API (Application program interface) available to the mobile game Cannon Color.

Notes to be aware of:
* This is a Restful JSON API web-service, which conforms to the constraints and characteristic of the Rest architectural style and uses JSON as its data representational format.
* Uses Basic Authentication with Spring.
* The API will be available over a HTTPS channel.

## Profiles

dev: aplication with security disable

##  api version [/cockatoo/version] [GET]

Returns the version of the api
If everything went ok it should return a http status ok (200) with the payload.

+ Request

  + Headers

            Authorization: Basic eyJhbGciOiJIUzI1NiJ9

+ Response 200 (application/hal+json)

   + Body

            {
             version: 0.0.1
            }
            
##  register api build [/cockatoo/api/player] [POST]

Register build player
If everything went ok it should return a http status ok (200) with the payload.

+ Body

        {
        	"buildId": "example1",
        	"gameName": "bloas", 
        	"platform":"ss",
        	"creationDate": "25-56-32"
        }

  + Headers

            Authorization: Basic eyJhbGciOiJIUzI1NiJ9

+ Response 200 (application/json)


##  update api build [/cockatoo/api/player/update/lvl-setting] [POST]

Update level player setting
If everything went ok it should return a http status ok (200) with the payload.

+ Body

        {
        	"buildId": "example1",
        	"levelReferenceName": "Level_1",
        	"totalLevelEnemy": 3,
        	"enemySpeedRange": 1.0,
        	"enemySpeedPercent1": 1.5,
        	"enemySpeedPercent2": 1,
        	"enemyTimeSpawnRange": 1.6,
        	"enemyTimeSpawnPercent1": 1,
        	"enemyTimeSpawnPercent2": 1.6,
        	"enemyBaseSpeed": 1,
        	"enemyBaseTimeSpawn": 1
        }

  + Headers

            Authorization: Basic eyJhbGciOiJIUzI1NiJ9

+ Response 200 (application/json)
+ 


##  update api level status [/cockatoo/api/player/update/lvl-status] [POST]

Update level status player
If everything went ok it should return a http status ok (200) with the payload.

+ Body

       {
       	
       	"buildId": "example1",
       	"levelName": "Level_Name",
       	"playerPoints": 100,
       	"playerLife": 3,
       	"playerCompleteTime": "500.63",
       	"isLevelComplete": "TRUE"
       }

  + Headers

            Authorization: Basic eyJhbGciOiJIUzI1NiJ9

+ Response 200 (application/json)
+ 

##  Get player Info [/cockatoo/api/player] [GET]

Get information of player status
If everything went ok it should return a http status ok (200) with the payload.

+ Request Param 

        builId=example1

  + Headers

            Authorization: Basic eyJhbGciOiJIUzI1NiJ9

+ Response 200 (application/json)

  + Body

        {
            "buildId": "example1",
            "gameName": "bloas",
            "platform": "ss",
            "creationDate": "25-56-32",
            "levelSettingDTOList": [
                {
                    "buildId": "example1",
                    "levelReferenceName": "Level_1",
                    "totalLevelEnemy": 3,
                    "enemySpeedRange": 1.0,
                    "enemySpeedPercent1": 1.5,
                    "enemySpeedPercent2": 1.0,
                    "enemyTimeSpawnRange": 1.6,
                    "enemyTimeSpawnPercent1": 1.0,
                    "enemyTimeSpawnPercent2": 1.6,
                    "enemyBaseSpeed": 1.0,
                    "enemyBaseTimeSpawn": 1.0
                }
            ],
            "levelStatusDTOList": [
                {
                    "buildId": "example1",
                    "levelName": "Level_Name",
                    "playerPoints": 100,
                    "playerCompleteTime": "500.63",
                    "isLevelComplete": "TRUE",
                    "playerRetryIntent": 3
                }
            ]
        }
        
##  Get player resume [/cockatoo/api/player/resume] [GET]

Get information of player 
If everything went ok it should return a list of player.


  + Headers

            Authorization: Basic eyJhbGciOiJIUzI1NiJ9

+ Response 200 (application/json)

  + Body

        [
            {
                "buildId": "818323f9-86dc-4328-9179-767b43b70ed1",
                "gameName": "CANNON COLOR",
                "platform": "WINDOW",
                "creationDate": "2020-01-28T15:01:26Z",
                "levelSettingDTOList": null,
                "levelStatusDTOList": null
            }
        ]
