#!/usr/bin/env bash
echo "Upload the apk to app center"

#Issue: Gen apk upload url of appcenter
urlRequestRspJson=$(curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' --header "X-API-Token: ${upload_token}" 'https://api.appcenter.ms/v0.1/apps/post2shyam/abcd/release_uploads')

#Extract upload id from the above response
upload_id=$(echo  ${urlRequestRspJson} | jq --raw-output '.upload_id')

#Extract the upload url from the above response
upload_url=$(echo  ${urlRequestRspJson} | jq --raw-output '.upload_url')

echo ${upload_id}
echo ${upload_url}

#Upload the apk file to the upload the url
uploadRspJson=$(curl -F "ipa=@../app/build/outputs/apk/release/app-release-unsigned.apk" ${upload_url})

echo ${uploadRspJson}

#Extract the release_url from the uploadRspJson
release_url=$(echo  ${uploadRspJson} | jq --raw-output '.release_url')


#Update upload resource's status to committed
statusRsp=$(curl -X PATCH --header 'Content-Type: application/json' --header 'Accept: application/json' --header "X-API-Token: ${upload_token}" -d '{ "status": "committed"  }' "https://api.appcenter.ms/v0.1/apps/post2shyam/abcd/release_uploads/${upload_id}")
echo $statusRsp

#Distribute the uploaded release to distribution group
relNotesRsp=$(curl -X PATCH --header 'Content-Type: application/json' --header 'Accept: application/json' --header "X-API-Token: ${upload_token}" -d '{ "destination_name": "QA Testers", "release_notes": "Example new release is available" }' 'https://api.appcenter.ms/v0.1/apps/post2shyam/abcd/releases/2')
echo ${relNotesRsp}

